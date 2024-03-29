package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        List<Product> productIterator = productRepository.findAll();
        assertTrue(! productIterator.isEmpty());
        Product savedProduct = productIterator.get(0);
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        List <Product> productIterator = productRepository.findAll();
        assertFalse(! productIterator.isEmpty());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        List <Product> productIterator = productRepository.findAll();
        assertTrue(! productIterator.isEmpty());

        Product savedProduct = productIterator.get(0);
        assertEquals(product1.getProductId(), savedProduct.getProductId());

        savedProduct = productIterator.get(1);
        assertEquals(product2.getProductId(), savedProduct.getProductId());
    }

    @Test
    void testEditExistingProduct() {
        Product testingProduct = new Product();
        testingProduct.setProductName("Produk 1");
        testingProduct.setProductQuantity(12);

        productRepository.create(testingProduct);

        Product testingEditedProduct = new Product();
        testingEditedProduct.setProductId(testingProduct.getProductId());
        testingEditedProduct.setProductName("Produk Baru 1");
        testingEditedProduct.setProductQuantity(19);

        Product testingEdit = productRepository.edit(testingEditedProduct);

        assertNotNull(testingEdit);
        assertEquals("Produk Baru 1", testingEdit.getProductName());
        assertEquals(19, testingEdit.getProductQuantity());
    }

    @Test
    void testEditNonExistingProduct() {
        Product testingEditedProduct = new Product();
        testingEditedProduct.setProductId("XXXXX(This Shouldn't Exist)");
        testingEditedProduct.setProductName("Produk Baru 2");
        testingEditedProduct.setProductQuantity(29);

        Product testingEdit = productRepository.edit(testingEditedProduct);

        assertNull(testingEdit);
    }

    @Test
    void testDeleteExistingProduct() {
        Product testingProduct = new Product();
        testingProduct.setProductName("Produk 3");
        testingProduct.setProductQuantity(144);

        productRepository.create(testingProduct);

        System.out.println("HALOOO");
        boolean testingDelete = productRepository.delete(testingProduct.getProductId());
        assertEquals(testingDelete, true);

        Product testingSearchDeletedProduct = productRepository.findById(testingProduct.getProductId());
        assertNull(testingSearchDeletedProduct);
    }

    @Test
    void testDeleteNonExistingProduct() {
        boolean testingDelete = productRepository.delete("XXXX(This Shouldn't Exist");
        assertEquals(testingDelete, false);
    }
}