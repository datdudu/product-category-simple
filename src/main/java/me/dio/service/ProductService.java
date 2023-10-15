package me.dio.service;

import me.dio.domain.model.Product;

import java.util.List;

public interface ProductService {
    Iterable<Product> findProducts();
    Product findById(Long id);
    Product createProduct (Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);


}
