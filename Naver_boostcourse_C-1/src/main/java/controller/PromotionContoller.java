package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.PromotionService;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class PromotionContoller {

    private final PromotionService promotionService;

    public PromotionContoller(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping("/promotions")
    public HashMap<String, Object> getPromotionList() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", promotionService.getPromotionList());
        return map;
    }
}
