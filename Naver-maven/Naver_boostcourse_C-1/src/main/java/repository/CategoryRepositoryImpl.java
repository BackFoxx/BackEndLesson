package repository;

import dto.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static repository.CategoryRepositorySqls.*;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private RowMapper<Category> categoryRowMapper = BeanPropertyRowMapper.newInstance(Category.class);

    public CategoryRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    //카테고리 목록 구하기
    @Override
    public List<Category> selectAllCategories() {
        return jdbcTemplate.query(SELECT_ALL_CATEGORIES, categoryRowMapper);
    }

}
