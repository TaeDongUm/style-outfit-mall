package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import dshop.style_outfit_mall.enums.ProductStatus;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;  // 상품 이름

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;  // 카테고리 (FK)

    @Column(nullable = false)
    private int price;  // 상품 가격

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;  // 상품 상태 (Enum)

    @Column(nullable = false)
    private int availableQuantity;  // 판매 가능 수량

    private LocalDateTime registeredAt;  // 상품 등록 시각

    private LocalDateTime updatedAt;  // 상품 정보 수정 시각

    private LocalDateTime soldAt;  // 상품 판매 시각

    private String description;  // 상품 설명
}


