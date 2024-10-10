package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    private String id;  // 아이디

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;  // 주소 ID (FK)

    @Column(nullable = false)
    private String nickname;  // 별명

    @Column(nullable = false)
    private String password;  // 비밀번호

    @Column(nullable = false)
    private String name;  // 이름

    @Column(unique = true, nullable = false)
    private String email;  // 이메일 (유니크)

    @Column(nullable = false)
    private String phoneNumber;  // 핸드폰 번호

    @Column(nullable = false)
    private LocalDateTime createdAt;  // 계정 생성 시각

    private LocalDateTime updatedAt;  // 계정 정보 수정 시각

    private LocalDateTime lastLoginDate;  // 마지막 로그인 시각

    private LocalDateTime deletedAt;  // 계정 삭제 시각
}
