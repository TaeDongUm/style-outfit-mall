package dshop.style_outfit_mall.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Category {

    @Id
    private String id;  // 카테고리 ID (PK)

    @Column(nullable = false)
    private String name;  // 카테고리 이름

    private LocalDateTime createdAt;  // 카테고리 등록 시간

    private LocalDateTime updatedAt;  // 카테고리 수정 시간

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parentCategory;  // 부모 카테고리 (자기 참조 관계)
}

