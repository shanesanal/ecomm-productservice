package com.ecommerce.ecommproductservice.Service;

import com.ecommerce.ecommproductservice.Config.RestTemplateConfig;
import com.ecommerce.ecommproductservice.Model.Product;
import com.ecommerce.ecommproductservice.Repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final RestTemplateConfig restTemplate;

    public ProductService(ProductRepository productRepository, RestTemplateConfig restTemplate) {
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches products from the FakestoreAPI and saves them to the database.
     *
     * @return List of saved products.
     */
    public List<Product> fetchProductsFromApi() {
        String apiUrl = "https://fakestoreapi.com/products";
        Product[] products = restTemplate.restTemplate().getForObject(apiUrl, Product[].class);
        return productRepository.saveAll(List.of(products));
    }

    /**
     * Saves a new product to the database.
     *
     * @param product The product to be saved.
     * @return The saved product.
     */
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Retrieves a product by its ID from the cache or database.
     *
     * @param id The ID of the product to be retrieved.
     * @return Optional containing the product if found, otherwise empty.
     */
    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * Retrieves all products from the database.
     *
     * @return List of all products.
     */
    @Cacheable(value = "allProducts")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Deletes a product by its ID from the database.
     *
     * @param id The ID of the product to be deleted.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
