package dshop.style_outfit_mall.domain;

import dshop.style_outfit_mall.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;  // 주문 ID (FK)

    @OneToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;  // 주소 ID (FK)

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;  // 배달 상태 (Enum)
}


