package repository;

import dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static repository.RepositorySqls.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    final int LIMIT = 4;

    @Override
    public List<Product> getProductsList(int categoryId, int start) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", categoryId)
                .addValue("start", start)
                .addValue("limit", LIMIT);
        return jdbcTemplate.query(SELECT_PRODUCTS, params, productRowMapper);
    }

    @Override
    public int getTotalCount(int categoryId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", categoryId);
        return jdbcTemplate.queryForObject(TOTAL_COUNT, params, Integer.class);
    }

    @Override
    public double getAverageScore(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        Double queryResult = jdbcTemplate.queryForObject(AVERAGE_SCORE, params, Double.class);
        if (queryResult == null) queryResult = 0.0;
        return queryResult;
    }

    private RowMapper<Comments> commentRowMapper = (rs, rowNum) -> {

        CommentImage commentImage = new CommentImage();
        commentImage.setContentType(rs.getString("file_content_type"));
        commentImage.setCreateDate(rs.getString("file_create_date"));
        commentImage.setDeleteFlag(rs.getBoolean("file_delete_flag"));
        commentImage.setFileId(rs.getInt("file_file_id"));
        commentImage.setFileName(rs.getString("file_file_name"));
        commentImage.setImageId(rs.getInt("file_image_id"));
        commentImage.setModifyDate(rs.getString("file_modify_date"));
        commentImage.setReservationInfoId(rs.getInt("file_reservation_info_id"));
        commentImage.setReservationUserCommentId(rs.getInt("file_reservation_user_comment_id"));
        commentImage.setSaveFileName(rs.getString("file_save_file_name"));

        Comments comments = new Comments();
        comments.setComment(rs.getString("comment"));
        comments.setCommentId(rs.getInt("comment_id"));
        if (rs.getString("file_file_name") != null) {
            List<CommentImage> commentImageList = new ArrayList<>();
            commentImageList.add(commentImage);
            comments.setCommentImage(commentImageList);
        }

        comments.setCreateDate(rs.getString("create_date"));
        comments.setModifyDate(rs.getString("modify_date"));

        comments.setProductId(rs.getInt("product_id"));

        comments.setReservationDate(rs.getString("reservation_date"));
        comments.setReservationEmail(rs.getString("reservation_email"));
        comments.setReservationInfoId(rs.getInt("reservation_info_id"));
        comments.setReservationName(rs.getString("reservation_name"));
        comments.setReservationTelephone(rs.getString("reservation_telephone"));

        comments.setScore(rs.getDouble("score"));

        return comments;
        };

    @Override
    public List<Comments> getComments(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        return jdbcTemplate.query(COMMENT, params, commentRowMapper);
    }

    RowMapper<DisplayInfo> displayInfoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);

    @Override
    public DisplayInfo getDisplayInfo(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        return jdbcTemplate.queryForObject(DISPLAY_INFO, params, displayInfoRowMapper);
    }

    RowMapper<DisplayInfoImage> displayInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);

    @Override
    public DisplayInfoImage getDisplayInfoImage(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        return jdbcTemplate.queryForObject(DISPLAY_INFO_IMAGE, params, displayInfoImageRowMapper);
    }

    RowMapper<ProductImages> productImagesRowMapper = BeanPropertyRowMapper.newInstance(ProductImages.class);

    @Override
    public List<ProductImages> getProductImages(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        return jdbcTemplate.query(PRODUCT_IMAGE, params, productImagesRowMapper);
    }

    RowMapper<ProductPrices> productPricesRowMapper = BeanPropertyRowMapper.newInstance(ProductPrices.class);

    @Override
    public List<ProductPrices> getProductPrices(int displayInfoId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("displayInfoId", displayInfoId);
        return jdbcTemplate.query(PRODUCT_PRICE, params, productPricesRowMapper);
    }
}
