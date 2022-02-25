package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CategoryRepository;

import java.util.HashMap;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @Override
    @Transactional
    public HashMap<String, Object> getCategories() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("items", repository.selectAllCategories());
        return map;
    }
}
