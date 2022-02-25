package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ProductRepository;

import java.util.HashMap;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public HashMap<String, Object> getProducts(int categoryId, int start) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("totalCount", repository.getTotalCount(categoryId));
        map.put("items", repository.getProductsList(categoryId, start));
        return map;
    }

    @Override
    @Transactional
    public HashMap<String, Object> getDisplayInfo(int displayInfoId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("averageScore", repository.getAverageScore(displayInfoId));
        map.put("comments", repository.getComments(displayInfoId));
        map.put("displayInfo", repository.getDisplayInfo(displayInfoId));
        map.put("displayInfoImage", repository.getDisplayInfoImage(displayInfoId));
        map.put("productImages", repository.getProductImages(displayInfoId));
        map.put("productPrices", repository.getProductPrices(displayInfoId));
        return map;
    }
}
