package com.sparta.msa_exam.order.entity;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseOrderDto {

    private Long orderId;
    private List<Long> productIds;

    public static ResponseOrderDto from(Orders order, List<OrderProducts> productIds) {
        return ResponseOrderDto.builder()
                .orderId(order.getOrderId())
                .productIds(productIds
                        .stream()
                        .map(OrderProducts::getProductId)
                        .toList())
                .build();
    }
}
