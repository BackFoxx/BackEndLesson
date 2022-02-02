package org.example.dao;

import org.example.dto.Role;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.example.dao.RoleDaoSqls.*;

@Repository
public class RoleDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);

    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("role");
    }

    public List<Role> selectAll() {
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
    }

    public Role selectOne(int Id) {
        try {
            SqlParameterSource params = new MapSqlParameterSource().addValue("roleId", Id);
            return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("존재하지 않는 아이디");
            return null;
        }
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insertAction.execute(params);
    }

    public int update(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        System.out.println("params = " + params);
        return jdbc.update(UPDATE, params);
    }

    public int delete(int Id) {
        Map<String, Integer> params = Collections.singletonMap("roleId", Id);
        return jdbc.update(DELETE_BY_ROLE_ID, params);
    }

}
