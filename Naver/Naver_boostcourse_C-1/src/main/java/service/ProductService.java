package service;

import dto.Product;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
    public HashMap<String, Object> getProducts(int categoryId, int start);
    public HashMap<String, Object> getDisplayInfo(int displayInfoId);
}
