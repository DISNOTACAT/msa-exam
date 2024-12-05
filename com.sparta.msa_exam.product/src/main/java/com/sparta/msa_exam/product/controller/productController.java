package com.sparta.msa_exam.product.controller;

import com.sparta.msa_exam.product.entity.RequestProductDto;
import com.sparta.msa_exam.product.entity.ResponseProductDto;
import com.sparta.msa_exam.product.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class productController {


    private final ProductService productService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDto> getProductOne(@PathVariable("id") int id, @RequestHeader HttpHeaders headers) {

        ResponseProductDto response = productService.findById((long) id);
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ResponseProductDto>> getAllProducts(@RequestHeader HttpHeaders headers) {

        List<ResponseProductDto> response = productService.findAllProducts();

        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody RequestProductDto request, @RequestHeader HttpHeaders headers) {

        productService.createProduct(request);
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>("create success", headers, HttpStatus.CREATED);
    }

}
