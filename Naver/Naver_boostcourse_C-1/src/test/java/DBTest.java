import config.DataSourceConfig;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.assertj.core.api.Assertions.*;

public class DBTest {

    @Test
    public void DB테스트() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DataSourceConfig.class);

        DataSource bean = ac.getBean(DataSource.class);
        try {
            Connection connection = bean.getConnection();
            assertThat(connection).isNotNull();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
