package service;

import dto.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductsList(int categoryId, int start);
    public int totalCount(int categoryId);
}
