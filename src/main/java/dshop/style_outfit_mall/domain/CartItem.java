package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;  // 장바구니 ID (FK)

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // 상품 ID (FK)

    @Column(nullable = false)
    private int quantity;  // 상품 수량

    @Column(nullable = false)
    private int price;  // 가격
}
