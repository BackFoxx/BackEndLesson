package service;

import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> getProductsList(int categoryId, int start) {
        return repository.getProductsList(categoryId, start);
    }

    @Override
    public int totalCount(int categoryId) {
        return repository.getTotalCount(categoryId);
    }
}
