package service;

import dto.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {
    public List<Map<String, Object>> selectAllCategories();
}
