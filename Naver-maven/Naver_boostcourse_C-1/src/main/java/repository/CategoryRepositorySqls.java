package repository;

public class CategoryRepositorySqls {
    public static final String SELECT_ALL_CATEGORIES = "SELECT c.id, c.name, count(p.category_id) count FROM category c INNER JOIN product p on c.id = p.category_id GROUP BY c.id";
}
