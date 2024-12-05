package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.entity.RequestProductDto;
import com.sparta.msa_exam.product.entity.ResponseProductDto;
import com.sparta.msa_exam.product.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    @Transactional(readOnly = true)
    public ResponseProductDto findById(Long id) {

        return repository.findById(id)
                .map(ResponseProductDto::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public List<ResponseProductDto> findAllProducts() {

        return Optional.of(repository.findAll())
                .filter(list -> !list.isEmpty())
                .map(list -> list.stream().map(ResponseProductDto::fromEntity).toList())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    public void createProduct(RequestProductDto request) {

        repository.save(RequestProductDto.toEntity(request));
    }
}
