package com.sparta.msa_exam.product.entity;

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
public class RequestProductDto {

    private String name;
    private Integer supplyPrice;

    public static Products toEntity(RequestProductDto dto) {
        return Products.builder()
                .name(dto.getName())
                .supplyPrice(dto.getSupplyPrice())
                .build();
    }

}
