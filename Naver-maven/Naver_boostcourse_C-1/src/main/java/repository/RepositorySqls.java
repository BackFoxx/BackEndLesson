package repository;

public class RepositorySqls {
    public static final String SELECT_ALL_CATEGORIES = "SELECT c.id, c.name, count(p.category_id) count FROM category c INNER JOIN product p on c.id = p.category_id GROUP BY c.id";
    public static final String SELECT_ALL_PROMOTIONS = "SELECT p.id, p.product_id, fi.save_file_name product_image_url FROM promotion p INNER JOIN product_image pi ON p.product_id = pi.product_id INNER JOIN file_info fi ON pi.file_id = fi.id GROUP BY p.id";
    public static final String SELECT_PRODUCTS =
            "select di.id display_info_id, di.place_name place_name, p.content product_content, p.description product_description, p.id product_id, fi.save_file_name product_image_url from product p " +
            "inner join category c on p.category_id = c.id " +
            "inner join display_info di on p.id = di.product_id " +
            "inner join product_image pi on p.id = pi.product_id " +
            "inner join file_info fi on pi.file_id = fi.id " +
            "where c.id = :id and fi.file_name like '%_th_%' " +
            "limit :start, :limit";
    public static final String SELECT_ALL_PRODUCTS =
            "select di.id display_info_id, di.place_name place_name, p.content product_content, p.description product_description, p.id product_id, fi.save_file_name product_image_url from product p " +
            "inner join category c on p.category_id = c.id " +
            "inner join display_info di on p.id = di.product_id " +
            "inner join product_image pi on p.id = pi.product_id " +
            "inner join file_info fi on pi.file_id = fi.id " +
            "where fi.file_name like '%_th_%' " +
            "limit :start, :limit";
    public static final String TOTALCOUNT = "select count(*) total_count from category c inner join product p on c.id = p.category_id where c.id=:id group by c.id";
    public static final String ALLCATEGORIES_TOTALCOUNT = "select count(*) total_count from category c inner join product p on c.id = p.category_id";
}
