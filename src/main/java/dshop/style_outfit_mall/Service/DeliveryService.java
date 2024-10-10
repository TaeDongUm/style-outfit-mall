package dshop.style_outfit_mall.Service;

import dshop.style_outfit_mall.domain.Delivery;
import dshop.style_outfit_mall.Repository.DeliveryRepository;
import dshop.style_outfit_mall.dto.DeliveryStatusRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery getDeliveryByOrderId(Long ordersId) {
        return deliveryRepository.findByOrdersId(ordersId)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }

    public Delivery updateDeliveryStatus(Long ordersId, DeliveryStatusRequest deliveryStatusRequest) {
        Delivery delivery = getDeliveryByOrderId(ordersId);
        // 배송 상태 업데이트 로직
        delivery.setStatus(deliveryStatusRequest.getStatus());
        return deliveryRepository.save(delivery);
    }
}

