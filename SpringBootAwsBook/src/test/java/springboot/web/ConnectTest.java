package springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectTest {
    @Autowired
    DataSource dataSource;

    @Test
    void 연결() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println("connection.getMetaData().getURL() = " + connection.getMetaData().getURL());
        System.out.println("connection.getMetaData().getUserName() = " + connection.getMetaData().getUserName());
    }
}
