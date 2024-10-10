package dshop.style_outfit_mall.Controller;

import dshop.style_outfit_mall.domain.Delivery;
import dshop.style_outfit_mall.Service.DeliveryService;
import dshop.style_outfit_mall.dto.DeliveryStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Delivery> getDeliveryInfo(@PathVariable Long orderId) {
        Delivery delivery = deliveryService.getDeliveryByOrderId(orderId);
        return ResponseEntity.ok(delivery);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Delivery> updateDeliveryStatus(@PathVariable Long orderId, @RequestBody DeliveryStatusRequest deliveryStatusRequest) {
        Delivery updatedDelivery = deliveryService.updateDeliveryStatus(orderId, deliveryStatusRequest);
        return ResponseEntity.ok(updatedDelivery);
    }
}
