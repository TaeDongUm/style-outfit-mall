package dshop.style_outfit_mall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {
    private String productId;  // 상품 ID
    private int quantity;       // 수량
}
