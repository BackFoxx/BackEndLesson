package repository;

import dto.Comment;
import dto.CommentImage;
import dto.DisplayInfo;
import dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

import static repository.RepositorySqls.*;

@Service
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
        return jdbcTemplate.queryForObject(AVERAGE_SCORE, params, Double.class);
    }

    private RowMapper<Comment> commentRowMapper = (rs, rowNum) -> {

        CommentImage commentImage = new CommentImage();
        commentImage.setContentType(rs.getString("file_content_type"));
        commentImage.setCreateDate(rs.getDate("file_create_date"));
        commentImage.setDeleteFlag(rs.getBoolean("file_delete_flag"));
        commentImage.setFileId(rs.getInt("file_file_id"));
        commentImage.setFileName(rs.getString("file_file_name"));
        commentImage.setImageId(rs.getInt("file_image_id"));
        commentImage.setModifyDate(rs.getDate("file_modify_date"));
        commentImage.setReservationInfoId(rs.getInt("file_reservation_info_id"));
        commentImage.setReservationUserCommentId(rs.getInt("file_reservation_user_comment_id"));
        commentImage.setSaveFileName(rs.getString("file_save_file_name"));

        Comment comment = new Comment();
        comment.setComment(rs.getString("comment"));
        comment.setCommentId(rs.getInt("comment_id"));
        if (rs.getString("file_file_name") != null) {
            comment.setCommentImage(commentImage);
        }

        comment.setCreateDate(rs.getDate("create_date"));
        comment.setModifyDate(rs.getDate("modify_date"));

        comment.setProductId(rs.getInt("product_id"));

        comment.setReservationDate(rs.getDate("reservation_date"));
        comment.setReservationEmail(rs.getString("reservation_email"));
        comment.setReservationInfoId(rs.getInt("reservation_info_id"));
        comment.setReservationName(rs.getString("reservation_name"));
        comment.setReservationTelephone(rs.getString("reservation_telephone"));

        comment.setScore(rs.getDouble("score"));

        return comment;
        };

    @Override
    public List<Comment> getComment(int displayInfoId) {
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
}
