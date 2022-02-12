package repository;

import dto.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> getProductsList(int categoryId, int start);
    public int totalCount(int categoryId);
}
