package repository;

import dto.Category;
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
public class CategoryRepositoryImpl implements CategoryRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Map<String, Object>> categoryRowMapper = new ColumnMapRowMapper();

    @Autowired
    public CategoryRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    //카테고리 목록 구하기
    @Override
    public List<Map<String, Object>> selectAllCategories() {
        return jdbcTemplate.query(SELECT_ALL_CATEGORIES, categoryRowMapper);
    }

}
