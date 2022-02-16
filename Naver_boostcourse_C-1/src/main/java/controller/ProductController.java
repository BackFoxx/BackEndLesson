package controller;

import org.springframework.web.bind.annotation.*;
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
    public HashMap<String, Object> getProductList(@RequestParam(name = "categoryId", defaultValue = "0") Integer categoryId, @RequestParam(name = "start", defaultValue = "0") int start) {
        return productService.getProducts(categoryId, start);
    }
    //categoryId가 0인 경우 전체 카테고리 리스트를 대상으로 한다.

    @GetMapping("/products/{displayInfoId}")
    public HashMap<String, Object> getDisplayInfo(@PathVariable(name = "displayInfoId") int displayInfoId) {
        return productService.getDisplayInfo(displayInfoId);
    }
}
