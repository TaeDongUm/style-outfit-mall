package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;  // 주문 ID (FK)

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // 상품 ID (FK)

    @Column(nullable = false)
    private int orderPrice;  // 주문 가격

    @Column(nullable = false)
    private int count;  // 개수
}

