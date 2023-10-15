package me.dio.service.impl;

import me.dio.domain.model.Product;
import me.dio.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService implements me.dio.service.ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Iterable<Product> findProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {

        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Product createProduct(Product product) {
        if(product.getId() != null && productRepository.existsById(product.getId())){
            throw new IllegalArgumentException("This Product ID already exists");
        }

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);

        if(productOptional.isPresent()){
            product.setId(productOptional.get().getId());
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
