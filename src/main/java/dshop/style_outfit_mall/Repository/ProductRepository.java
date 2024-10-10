package dshop.style_outfit_mall.Repository;

import dshop.style_outfit_mall.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // 추가적인 쿼리 메서드
}

