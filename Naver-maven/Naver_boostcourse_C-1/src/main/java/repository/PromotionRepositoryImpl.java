package repository;

import dto.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

import static repository.RepositorySqls.*;

@Repository
public class PromotionRepositoryImpl implements PromotionRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Map<String, Object>> mapper = new ColumnMapRowMapper();

    @Autowired
    public PromotionRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Map<String, Object>> getPromotionList() {
        return jdbcTemplate.query(SELECT_ALL_PROMOTIONS, mapper);
    }
}
