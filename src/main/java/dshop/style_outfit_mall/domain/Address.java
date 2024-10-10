package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;  // 사용자 ID (FK)

    @Column(nullable = false)
    private String streetAddress;  // 도로명 주소

    @Column(nullable = false)
    private String detailAddress;  // 상세 주소

    @Column(nullable = false)
    private String postCode;  // 우편 번호

    private LocalDateTime updatedAt;  // 주소 정보 수정 시각
}
