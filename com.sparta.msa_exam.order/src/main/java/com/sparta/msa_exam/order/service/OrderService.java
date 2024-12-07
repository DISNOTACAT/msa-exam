package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.entity.OrderProducts;
import com.sparta.msa_exam.order.entity.Orders;
import com.sparta.msa_exam.order.entity.RequestOrderDto;
import com.sparta.msa_exam.order.entity.ResponseOrderDto;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final ProductClient productClient;

    public String getProduct(long id){
        return productClient.getProduct(Integer.parseInt(String.valueOf(id))).toString();
    }

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public void createProduct(RequestOrderDto request) {

        // 요청 상품ID 검증
        for(long id : request.getProductIds()) {
            if(!isProductIdExist(id)) throw new RuntimeException("product Id is not correct");
            log.info("Correct product Id : {}", id);
        }

        Orders order = RequestOrderDto.toEntity(request);
        orderRepository.save(order);

        for(Long id : request.getProductIds()) {
            orderProductRepository.save(new OrderProducts(order, id));
        }

    }

    public ResponseOrderDto findById(long orderId) {

        Orders order = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<OrderProducts> productsIds = orderProductRepository.findByOrder(order);

        return ResponseOrderDto.from(order, productsIds);
    }


    public boolean isProductIdExist(long productId) {
        return getProduct(productId) != null;
    }
}
