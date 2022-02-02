package org.example;

import org.example.config.ApplicationConfig;
import org.example.dao.RoleDao;
import org.example.dto.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JDBCTest {
    public ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    public RoleDao dao = ac.getBean(RoleDao.class);

    @Test
    public void 입력테스트() {
        Role role = new Role();
        role.setRoleId(500);
        role.setDescription("CEO");

        int count = dao.insert(role);
        System.out.println(count + "입력");
    }

    @Test
    public void 업데이트테스트()  {
        Role role = new Role();
        role.setRoleId(102);
        role.setDescription("망고보드");

        int count = dao.update(role);
        System.out.println(count + " 수정");
    }

    @Test
    public void 단건조회() {
        Role role = dao.selectOne(102);
        System.out.println(role.toString());
    }

    @Test
    public void 단건삭제() {
        int delete = dao.delete(500);
        System.out.println("delete = " + delete);
    }

    
}
