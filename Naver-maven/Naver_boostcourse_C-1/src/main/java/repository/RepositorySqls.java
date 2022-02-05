package repository;

public class RepositorySqls {
    public static final String SELECT_ALL_CATEGORIES = "SELECT c.id, c.name, count(p.category_id) count FROM category c INNER JOIN product p on c.id = p.category_id GROUP BY c.id";
    public static final String SELECT_ALL_PROMOTIONS = "SELECT p.id, p.product_id, fi.save_file_name product_image_url FROM promotion p INNER JOIN product_image pi ON p.product_id = pi.product_id INNER JOIN file_info fi ON pi.file_id = fi.id GROUP BY p.id";
}
