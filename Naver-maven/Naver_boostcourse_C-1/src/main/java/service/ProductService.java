package service;

import dto.Product;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Map<String, Object>> getProductsList(int categoryId, int start);
    public List<Map<String, Object>> getProductsList(int start);
    public int totalCount(int categoryId);
    public int totalCount();
}
