package dshop.style_outfit_mall.Repository;

import dshop.style_outfit_mall.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    Optional<Cart> findByUserId(String userId);
}

