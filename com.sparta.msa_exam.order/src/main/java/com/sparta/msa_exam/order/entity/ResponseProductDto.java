package com.sparta.msa_exam.product.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ResponseProductDto {

    private String name;
    private Integer supplyPrice;

    public static ResponseProductDto fromEntity(Products product) {
        return ResponseProductDto.builder()
                .name(product.getName())
                .supplyPrice(product.getSupplyPrice())
                .build();
    }
}
