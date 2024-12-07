package com.sparta.msa_exam.order.repository;

import com.sparta.msa_exam.order.entity.OrderProducts;
import com.sparta.msa_exam.order.entity.Orders;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProducts, Long> {
    List<OrderProducts> findByOrder(Orders order);
}
