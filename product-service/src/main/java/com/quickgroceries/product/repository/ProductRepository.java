package com.quickgroceries.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickgroceries.product.entity.Product;

/**
 * The Interface ProductRepository.
 */
public interface ProductRepository extends JpaRepository<Product,Long>{

}
