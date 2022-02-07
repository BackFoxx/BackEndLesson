package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static repository.RepositorySqls.*;

@Service
public class ProductRepositoryImpl implements ProductRepository {
    NamedParameterJdbcTemplate jdbcTemplate;
    RowMapper<Map<String, Object>> productRowMapper = new ColumnMapRowMapper();
    final int LIMIT = 4;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Map<String, Object>> getProductsList(int categoryId, int start) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", categoryId)
                .addValue("start", start)
                .addValue("limit", LIMIT);
        return jdbcTemplate.query(SELECT_PRODUCTS, params, productRowMapper);
    }

    @Override
    public List<Map<String, Object>> getProductsList(int start) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("start", start)
                .addValue("limit", LIMIT);
        return jdbcTemplate.query(SELECT_ALL_PRODUCTS, params, productRowMapper);
    }

    @Override
    public int totalCount(int categoryId) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", categoryId);
        return jdbcTemplate.queryForObject(TOTALCOUNT, params, Integer.class);
    }

    @Override
    public int totalCount() {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("start", 0);
        return jdbcTemplate.queryForObject(ALLCATEGORIES_TOTALCOUNT, params, Integer.class);
    }
}
