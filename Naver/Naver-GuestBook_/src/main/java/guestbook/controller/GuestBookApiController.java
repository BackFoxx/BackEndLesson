package guestbook.controller;

import guestbook.dto.GuestBook;
import guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/guestbooks")
public class GuestBookApiController {
    @Autowired
    GuestBookService guestBookService;

    @GetMapping
    public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {

        List<GuestBook> list = guestBookService.getGuestbooks(start);

        int count = guestBookService.getCount();
        int pageCount = count / guestBookService.LIMIT;
        if(count % guestBookService.LIMIT > 0)
            pageCount++;

        List<Integer> pageStartList = new ArrayList<>();
        for(int i = 0; i < pageCount; i++) {
            pageStartList.add(i * guestBookService.LIMIT);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("count", count);
        map.put("pageStartList", pageStartList);

        return map;
    }

    @PostMapping
    public GuestBook write(@RequestBody GuestBook guestbook,
                           HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();
        // id가 입력된 guestbook이 반환된다.
        GuestBook resultGuestbook = guestBookService.addGuestbook(guestbook, clientIp);
        return resultGuestbook;
    }

    @DeleteMapping("/{id}")
    public Map<String, String> delete(@PathVariable(name="id") Long id,
                                      HttpServletRequest request) {
        String clientIp = request.getRemoteAddr();

        int deleteCount = guestBookService.deleteGuestbook(id, clientIp);
        return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
    }
}
