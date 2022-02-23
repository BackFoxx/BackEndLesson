package argumentresolver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationParam {
    private int displayInfoId;
    private List<ReservationPrice> prices;
    private int productId;

    private String reservationEmail;
    private String reservationName;
    private String reservationTelephone;
    private String reservationYearMonthDay;
}
