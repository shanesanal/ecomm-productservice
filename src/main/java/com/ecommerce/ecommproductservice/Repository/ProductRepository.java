package com.ecommerce.ecommproductservice.Repository;

import com.ecommerce.ecommproductservice.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
