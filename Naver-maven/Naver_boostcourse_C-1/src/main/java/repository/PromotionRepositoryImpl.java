package repository;

import dto.Promotion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static repository.RepositorySqls.*;

@Repository
public class PromotionRepositoryImpl implements PromotionRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);

    public PromotionRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<Promotion> getPromotionList() {
        return jdbcTemplate.query(SELECT_ALL_PROMOTIONS, rowMapper);
    }
}
