package repository;

public class RepositorySqls {
    public static final String SELECT_ALL_CATEGORIES = "SELECT c.id id, c.name name, count(p.category_id) count FROM category c INNER JOIN product p on c.id = p.category_id GROUP BY c.id";
    public static final String SELECT_ALL_PROMOTIONS = "SELECT p.id id, p.product_id product_id, fi.save_file_name product_image_url FROM promotion p INNER JOIN product_image pi ON p.product_id = pi.product_id INNER JOIN file_info fi ON pi.file_id = fi.id GROUP BY p.id";
    public static final String SELECT_PRODUCTS =
    "select di.id display_info_id, di.place_name place_name, p.content product_content, p.description product_description, " +
    "p.id product_id, fi.save_file_name product_image_url from product p " +
    "inner join category c on p.category_id = c.id " +
    "inner join display_info di on p.id = di.product_id " +
    "inner join product_image pi on p.id = pi.product_id " +
    "inner join file_info fi on pi.file_id = fi.id " +
    "where c.id like if(:id = '0', '%', :id) " +
    "and fi.file_name like '%_th_%' " +
    "limit :start, :limit";
    public static final String TOTAL_COUNT = "select count(*) from display_info d inner join product p on d.product_id = p.id inner join category c on p.category_id = c.id where c.id like if(:id = 0, '%', :id)";

    public static final String AVERAGE_SCORE = "select avg(ruc.score) from reservation_user_comment ruc inner join display_info di on ruc.product_id = di.product_id where di.id = :displayInfoId";
    public static final String COMMENT = "select ruc.comment comment, ruc.id comment_id, ruc.create_date create_date, ruc.modify_date modify_date, ruc.product_id product_id, ri.reservation_date reservation_date, ri.reservation_email reservation_email, ruc.reservation_info_id reservation_info_id, ri.reservation_name reservation_name, ri.reservation_tel reservation_telephone, ruc.score score, fi.content_type file_content_type, fi.create_date file_create_date, fi.delete_flag file_delete_flag, fi.id file_file_id, fi.file_name file_file_name, ruci.id file_image_id, fi.modify_date file_modify_date, ruci.reservation_info_id file_reservation_info_id, ruci.reservation_user_comment_id file_reservation_user_comment_id, fi.save_file_name file_save_file_name from display_info di inner join reservation_user_comment ruc on di.product_id = ruc.product_id inner join reservation_info ri on ruc.reservation_info_id = ri.id left outer join reservation_user_comment_image ruci on ruc.id = ruci.reservation_user_comment_id left outer join file_info fi on ruci.file_id = fi.id where di.id = :displayInfoId;";
    public static final String DISPLAY_INFO = "select c.id category_id, c.name category_name, di.create_date create_date, di.id display_info_id, di.email email, di.homepage homepage, di.modify_date modify_date, di.opening_hours opening_hours, di.place_lot place_lot, di.place_name place_name, di.place_street place_street, p.content product_content, p.description product_description, p.event product_event, p.id product_id, di.tel telephone from display_info di inner join product p on di.product_id = p.id inner join category c on p.category_id = c.id where di.id = :displayInfoId";
}
