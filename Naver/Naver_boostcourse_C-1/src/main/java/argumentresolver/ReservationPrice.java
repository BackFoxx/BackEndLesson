package argumentresolver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationPrice {
    private int count;
    private int productPriceId;
    private int reservationInfoId;
    private int reservationInfoPriceId;
}
