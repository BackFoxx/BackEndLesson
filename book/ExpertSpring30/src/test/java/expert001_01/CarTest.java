package expert001_01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_장착_타이어브랜드_테스트() {
        Car car = new Car();
        Assertions.assertThat(car.getTireBrand()).isEqualTo("장착된 타이어: 코리아 타이어");
    }
}