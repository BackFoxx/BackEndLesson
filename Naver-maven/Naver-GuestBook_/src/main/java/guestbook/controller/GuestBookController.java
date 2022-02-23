package guestbook.controller;

import guestbook.dto.GuestBook;
import guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestBookController {
    @Autowired
    GuestBookService service;

    @GetMapping(path="/list")
    public String list(@RequestParam(name="start", required=false, defaultValue="0") int start,
                       ModelMap model, HttpServletRequest request, HttpServletResponse response) {

        String value = null;
        boolean find = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("count".equals(cookie.getName())) {
                    find = true;
                    value = cookie.getValue();
                }
            }
        }

        if (!find) {
            value = "1";
        } else {
            try {
                int i = Integer.parseInt(value);
                value = Integer.toString(++i);
            } catch (Exception e) {
                value = "1";
            }
        }

        Cookie cookie = new Cookie("count", value);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        response.addCookie(cookie);

        // start로 시작하는 방명록 목록 구하기
        List<GuestBook> list = service.getGuestbooks(start);

        // 전체 페이지수 구하기
        int count = service.getCount();
        int pageCount = count / service.LIMIT;
        if(count % service.LIMIT > 0)
            pageCount++;

        // 페이지 수만큼 start의 값을 리스트로 저장
        // 예를 들면 페이지수가 3이면
        // 0, 5, 10 이렇게 저장된다.
        // list?start=0 , list?start=5, list?start=10 으로 링크가 걸린다.
        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * service.LIMIT);
        }

        model.addAttribute("list", list);
        model.addAttribute("count", count);
        model.addAttribute("pageStartList", pageStartList);
        model.addAttribute("cookieCount", value);

        return "list";
    }

    @PostMapping(path="/write")
    public String write(@ModelAttribute GuestBook guestbook,
                        HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        System.out.println("clientIp : " + clientIp);
        service.addGuestbook(guestbook, clientIp);
        return "redirect:list";
    }
}
