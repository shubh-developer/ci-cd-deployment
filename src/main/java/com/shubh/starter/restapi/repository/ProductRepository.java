package com.shubh.starter.restapi.repository;
import com.shubh.starter.restapi.model.MProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<MProduct, Long> {
}