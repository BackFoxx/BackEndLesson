package expert002;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration("expert003.xml")
class Driver2Test {
    @Autowired
    Car car;

    @Test
    void 자동차_코리아타이어_장착_타이어브랜드_테스트() {
        Assertions.assertThat(car.getTireBrand()).isEqualTo("장착된 타이어: 코리아 타이어");
    }
}