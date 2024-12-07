package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.entity.RequestOrderDto;
import com.sparta.msa_exam.order.entity.ResponseOrderDto;
import com.sparta.msa_exam.order.service.OrderService;
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
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody RequestOrderDto request, @RequestHeader HttpHeaders headers) {

        orderService.createProduct(request);
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>("create success", headers, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ResponseOrderDto> getOrderOne(@PathVariable("orderId") int orderId, @RequestHeader HttpHeaders headers) {

        ResponseOrderDto response = orderService.findById((long) orderId);
        headers.add("Server-Port", serverPort);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }




}
