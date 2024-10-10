package dshop.style_outfit_mall.Controller;

import dshop.style_outfit_mall.domain.Orders;
import dshop.style_outfit_mall.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        Orders createdOrder = orderService.createOrder(orders);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Orders>> getOrdersByUser(@PathVariable String userId) {
        List<Orders> orders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable String id) {
        orderService.cancelOrder(id);
        return ResponseEntity.noContent().build();
    }
}
