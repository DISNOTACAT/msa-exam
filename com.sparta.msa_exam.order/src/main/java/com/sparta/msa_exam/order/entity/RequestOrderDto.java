package com.sparta.msa_exam.order.entity;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestOrderDto {

    private List<Long> productIds;

    public static Orders toEntity(RequestOrderDto request) {
        return Orders.builder()
                .productIds(request.getProductIds().stream().map(OrderProducts::new).toList())
                .build();
    }
}
