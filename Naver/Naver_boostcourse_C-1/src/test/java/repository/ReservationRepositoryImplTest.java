package repository;

import argumentresolver.ReservationParam;
import argumentresolver.ReservationPrice;
import config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class ReservationRepositoryImplTest {

    @Test
    public void saveReservationInfo() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ReservationRepository repository = ac.getBean(ReservationRepository.class);


    }

    @Test
    public void saveReservationInfoPrice() {
    }
}