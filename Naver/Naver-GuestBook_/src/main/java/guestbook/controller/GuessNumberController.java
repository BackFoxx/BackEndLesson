package guestbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class GuessNumberController {
    @GetMapping("/guess")
    public String guess(@RequestParam(name = "number", required = false) Integer number, HttpSession session, ModelMap modelMap) {
        String message = null;
        if (number == null) {
            session.setAttribute("count", 0);
            session.setAttribute("randomNumber", (int) ((Math.random() * 100) + 1));
            message = "내가 생각한 숫자를 맞추어 보세요";
        } else {
            int count = (Integer) session.getAttribute("count");
            int randomNumber = (Integer) session.getAttribute("randomNumber");

            if (number < randomNumber) {
                message = "더 큽니다";
                session.setAttribute("count", ++count);
            } else if (number > randomNumber) {
                message = "더 작습니다";
                session.setAttribute("count", ++count);
            } else {
                message = "맞았습니다~" + ++count + " 번째 맞추었습니다. 내가 생각한 숫자는 " + randomNumber + "입니다.";
                session.removeAttribute("count");
                session.removeAttribute("randomNumber");
            }
        }

        modelMap.addAttribute("message", message);
        return "guess";
    }
}
