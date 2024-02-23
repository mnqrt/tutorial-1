package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository implements RepositoryInterface<Product> {
    private List <Product> productData = new ArrayList<>();

    public Product create (Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public Product edit (Product product) {
        for (Product currentProduct : productData) {
            if (product.getProductId().equals(currentProduct.getProductId())) {
                currentProduct.setProductName(product.getProductName());
                currentProduct.setProductQuantity(product.getProductQuantity());
                return currentProduct;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return productData;
    }

    public boolean delete (String productId) {
        boolean productExist = false;
        List<Product> productIterator = findAll();
        for (Product currentProduct : productIterator){
            String currentProductId = currentProduct.getProductId();
            if (currentProductId.equals(productId)) {
                productExist = true;
                productIterator.remove(currentProduct);
            }
        }
        return productExist;
    }

    public Product findById(String productId) {
        List<Product> productIterator = findAll();
        for (Product currentProduct : productIterator){
            String currentProductId = currentProduct.getProductId();
            if (currentProductId.equals(productId)) {
                return currentProduct;
            }
        }
        return null;
    }
}