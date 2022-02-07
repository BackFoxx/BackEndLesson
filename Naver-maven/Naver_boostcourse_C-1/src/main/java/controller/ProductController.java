package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public HashMap<String, Object> getProductList(@RequestParam(name = "categoryId", required = false) Integer categoryId, @RequestParam(name = "start", defaultValue = "0") int start) {
        HashMap<String, Object> map = new HashMap<>();
        if (categoryId == null) {
            map.put("totalCount", productService.totalCount());
            map.put("items", productService.getProductsList(start));
        } else {
            map.put("totalCount", productService.totalCount(categoryId));
            map.put("items", productService.getProductsList(categoryId, start));
        }
        return map;
    }
}
