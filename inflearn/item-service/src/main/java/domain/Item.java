package domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Item {

    private Long Id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
