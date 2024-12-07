package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.entity.ResponseProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/products/{id}")
    ResponseEntity<ResponseProductDto> getProduct(@PathVariable("id") int id);
}
