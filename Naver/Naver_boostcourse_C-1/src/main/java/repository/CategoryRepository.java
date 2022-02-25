package repository;

import dto.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> selectAllCategories();
}
