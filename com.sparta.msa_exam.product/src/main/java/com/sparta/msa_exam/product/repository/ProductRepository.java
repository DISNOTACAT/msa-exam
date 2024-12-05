package com.sparta.msa_exam.product.repository;

import com.sparta.msa_exam.product.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
