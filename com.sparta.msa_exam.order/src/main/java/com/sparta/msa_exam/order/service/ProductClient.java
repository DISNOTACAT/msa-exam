package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.entity.ResponseProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "products-service")
public interface ProductClient {

    @GetMapping("/{id}")
    String getProduct(@PathVariable("id") int id);
}
