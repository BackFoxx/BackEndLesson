package repository;

import argumentresolver.ReservationParam;

public interface ReservationRepository {
    public int saveReservationInfo(ReservationParam reservationParam);
    public int saveReservationInfoPrice(int reservation);
}
