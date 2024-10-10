package dshop.style_outfit_mall.Repository;

import dshop.style_outfit_mall.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, String> {
    List<Orders> findByUserId(String userId);
}

