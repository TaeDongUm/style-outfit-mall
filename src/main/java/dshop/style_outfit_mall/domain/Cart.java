package dshop.style_outfit_mall.domain;

import dshop.style_outfit_mall.dto.CartItemRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 사용자 ID (FK)

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public void addItem(CartItemRequest cartItemRequest) {
        CartItem cartItem = new CartItem();
//        cartItem.setProductId(cartItemRequest.getProductId());
        cartItem.setQuantity(cartItemRequest.getQuantity());
//        cartItem.setPrice(cartItemRequest.getPrice()); // 필요한 경우에만 설정

        // Cart와 CartItem 연결
        cartItem.setCart(this);
        items.add(cartItem);
    }

    // 장바구니에서 상품 제거 메서드도 추가할 수 있음
    public void removeItem(CartItem cartItem) {
        items.remove(cartItem);
        cartItem.setCart(null); // 양방향 연관관계 해제
    }

    private LocalDateTime createdAt;  // 장바구니 등록 시각

    private LocalDateTime updatedAt;  // 장바구니 수정 시각
}
