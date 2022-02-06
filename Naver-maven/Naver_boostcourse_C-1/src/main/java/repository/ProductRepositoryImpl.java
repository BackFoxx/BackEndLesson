package repository;

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
    RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    final int LIMIT = 5;

    @Autowired
    public ProductRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Product> getProductsList(int categoryId, int start) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", categoryId)
                .addValue("start", start)
                .addValue("limit", LIMIT);
        return jdbcTemplate.query(SELECT_ALL_PRODUCTS, params, productRowMapper);
    }
}
