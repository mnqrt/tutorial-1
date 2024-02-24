package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create (Product product) {
        productRepository.create(product);
        return product;
    }

    public Product edit (Product product) {
        return productRepository.edit(product);
    }

    @Override
    public List <Product> findAll() {
        List <Product> productIterator = productRepository.findAll();
        return productIterator;
    }

    @Override
    public boolean delete (String productId) {
        return productRepository.delete(productId);
    }
}