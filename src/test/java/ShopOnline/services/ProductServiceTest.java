package ShopOnline.services;
import ShopOnline.Category;
import ShopOnline.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ShopOnline.services.ProductService.products;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService();
    }

    @Test
    public void givenGenerateProductsMethod_whenCalled_thenProductListShouldNotBeEmpty() {

        // When
        List<Product> productList = ProductService.generateProducts();

        // Then
        Assertions.assertNotNull(productList);
        Assertions.assertFalse(productList.isEmpty());
    }

    @Test
    public void givenAddProductMethod_whenNewProductAdded_thenProductListSizeShouldIncrease() {
        // Given
        int initialSize = products.size();
        Category category = new Category("TestCategory");
        String productName = "TestProduct";
        double price = 99.99;
        int quantity = 10;

        // When
        productService.addProduct(productName, category, price, quantity);

        // Then
        Assertions.assertEquals(initialSize + 1, products.size());
    }

    @Test
    public void givenShowOneProductMethod_whenExistingProductShown_thenOutputContainsCorrectProduct() {
        // Given
        Category category = new Category("TestCategory");
        Product testProduct = new Product("TestProduct", category, 99.99, 10);
        productService.addProduct(testProduct.getProductName(), testProduct.getCategory(), testProduct.getPrice(), testProduct.getQuantity());

        // When

        // Then

    }

    @Test
    public void givenShowOneProductMethod_whenNonExistingProductShown_thenOutputContainsErrorMessage() {
        // Given
        int nonExistingProductId = 999;

        // When

        // Then
    }

    @Test
    public void givenFindProductByNameAndCategoryMethod_whenProductFound_thenCorrectProductShouldBeReturned() {
        // Given
        Category category = new Category("TestCategory");
        Product testProduct = new Product("TestProduct1", category, 99.99, 10);
        productService.addProduct(testProduct.getProductName(), testProduct.getCategory(), testProduct.getPrice(), testProduct.getQuantity());

        // When
        Product foundProduct = productService.findProductByNameAndCategory("TestProduct1");

        // Then
        assertThat(testProduct).isEqualTo(foundProduct);
    }
}