package org.example.name;

import org.example.config.ApplicationConfig;
import org.example.dao.RoleDao;
import org.example.dto.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {
    public ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    public RoleDao dao = ac.getBean(RoleDao.class);

    public void main(String[] args) {
        Role role = new Role();
        role.setRoleId(500);
        role.setDescription("CEO");

        int count = dao.insert(role);
        System.out.println(count + "입력");
    }
}
