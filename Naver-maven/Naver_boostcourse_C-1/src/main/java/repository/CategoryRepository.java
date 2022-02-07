package repository;

import dto.Category;

import java.util.List;
import java.util.Map;

public interface CategoryRepository {
    public List<Map<String, Object>> selectAllCategories();
}
