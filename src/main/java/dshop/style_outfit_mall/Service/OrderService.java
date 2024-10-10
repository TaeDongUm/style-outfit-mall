package dshop.style_outfit_mall.Service;

import dshop.style_outfit_mall.domain.Orders;
import dshop.style_outfit_mall.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Orders createOrder(Orders orders) {
        // 주문 생성 로직
        return orderRepository.save(orders);
    }

    public List<Orders> getOrdersByUserId(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public void cancelOrder(String id) {
        Orders orders = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        // 주문 취소 로직 (예: 주문 상태 변경 등)
        orderRepository.delete(orders);
    }
}
