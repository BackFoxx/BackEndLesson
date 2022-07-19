package expert001_03;

import expert002.AmericaTire;
import expert002.Car;
import expert002.KoreaTire;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 자동차_코리아타이어_장착_타이어브랜드_테스트() {
        KoreaTire koreaTire = new KoreaTire();
        Car car = new Car();
        car.setTire(koreaTire);
        Assertions.assertThat(car.getTireBrand()).isEqualTo("장착된 타이어: 코리아 타이어");
    }

    @Test
    void 자동차_미국타이어_장착_타이어브랜드_테스트() {
        AmericaTire americaTire = new AmericaTire();
        Car car = new Car();
        car.setTire(americaTire);
        Assertions.assertThat(car.getTireBrand()).isEqualTo("장착된 타이어: 미국 타이어");
    }
}