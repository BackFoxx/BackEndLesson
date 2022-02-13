package dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Promotion {
    private int id;
    private int productId;
    private String productImageUrl;
}
