package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductPrices {
    private Date createDate;
    private double discountRate;
    private Date modifyDate;
    private int price;
    private String priceTypeName;
    private int productId;
    private int productPriceId;
}
