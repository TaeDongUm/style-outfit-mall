package dshop.style_outfit_mall.dto;

import dshop.style_outfit_mall.enums.DeliveryStatus;  // DeliveryStatus enum import
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryStatusRequest {
    private DeliveryStatus status;  // 배송 상태 (enum)
}
