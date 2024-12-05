package com.sparta.msa_exam.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "supply_price")
    private Integer supplyPrice;

    @Builder
    public Products(Long productId, String name, Integer supplyPrice) {
        this.productId = productId;
        this.name = name;
        this.supplyPrice = supplyPrice;
    }
}
