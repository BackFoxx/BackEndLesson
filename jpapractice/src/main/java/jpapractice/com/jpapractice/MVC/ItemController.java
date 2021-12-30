package jpapractice.com.jpapractice.MVC;

import jpapractice.com.jpapractice.Entity.item.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
    @Autowired
    Itemservice itemservice;

    @GetMapping("/items/new")
    public String createForm() {
        return "items/createItemForm";
    }

    @RequestMapping(value = "/items/new", method = RequestMethod.POST)
    public String create(Book item) {
        itemservice.saveItem(item);
        return "redirect:/items";
    }
}
