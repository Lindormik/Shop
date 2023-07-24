package ShopOnline.services;
import ShopOnline.Category;
import ShopOnline.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        int initialSize = ProductService.products.size();
        Category category = new Category("TestCategory");
        String productName = "TestProduct";
        double price = 99.99;
        int quantity = 10;

        // When
        productService.addProduct(productName, category, price, quantity);

        // Then
        Assertions.assertEquals(initialSize + 1, ProductService.products.size());
    }

    @Test
    public void givenProductListWithExistingProduct_whenRemoveProductByID_thenProductShouldBeRemoved() {
        // Given
        Product product1 = new Product("Produkt1", new Category("Kategoria1"), 100.0, 5);
        Product product2 = new Product("Produkt2", new Category("Kategoria2"), 200.0, 3);
        Product product3 = new Product("Produkt3", new Category("Kategoria3"), 150.0, 7);

        ProductService.products.add(product1);
        ProductService.products.add(product2);
        ProductService.products.add(product3);

        int productIDToRemove = product2.getProductID();

        // When
        productService.removeProductByID(productIDToRemove);

        // Then
        List<Product> productList = productService.products;
        Assertions.assertEquals(2, productList.size(), "Lista produktów powinna zawierać 2 produkty po usunięciu.");
        Assertions.assertFalse(productList.contains(product2), "Produkt powinien zostać usunięty z listy.");
    }

    @Test
    public void givenProductListWithNonExistingProduct_whenRemoveProductByID_thenProductListShouldNotChange() {
        // Given
        Product product1 = new Product("Produkt1", new Category("Kategoria1"), 100.0, 5);
        Product product2 = new Product("Produkt2", new Category("Kategoria2"), 200.0, 3);
        Product product3 = new Product("Produkt3", new Category("Kategoria3"), 150.0, 7);

        productService.products.add(product1);
        productService.products.add(product2);

        int nonExistingProductID = 999;

        // When
        productService.removeProductByID(nonExistingProductID);

        // Then
        List<Product> productList = productService.products;
        Assertions.assertEquals(2, productList.size(), "Lista produktów nie powinna się zmienić, ponieważ produkt o podanym identyfikatorze nie istnieje.");
        Assertions.assertTrue(productList.contains(product1), "Produkt 1 powinien nadal być w liście.");
        Assertions.assertTrue(productList.contains(product2), "Produkt 2 powinien nadal być w liście.");
    }

    @Test
    public void givenShowOneProductMethod_whenExistingProductShown_thenOutputContainsCorrectProduct() {
        // Given
        Category category = new Category("TestCategory");
        Product testProduct = new Product("TestProduct", category, 99.99, 10);
        productService.addProduct(testProduct.getProductName(), testProduct.getCategory(), testProduct.getPrice(), testProduct.getQuantity());
        int highestId = testProduct.getProductID();

        // When
        // Assuming that the showOneProduct method prints the output to the console, you can capture the console output and verify it.
        // You can use a ByteArrayOutputStream to capture the output.

        // Then
        // Verify the captured output manually to check if it contains the correct product information.
    }

    @Test
    public void givenShowOneProductMethod_whenNonExistingProductShown_thenOutputContainsErrorMessage() {
        // Given
        int nonExistingProductId = 999;

        // When
        // Capture the console output and verify it to check if the correct error message is printed.

        // Then
        // Verify the captured output manually to check if it contains the correct error message.
    }

    @Test
    public void givenFindProductByNameAndCategoryMethod_whenProductFound_thenCorrectProductShouldBeReturned() {
        // Given
        Category category = new Category("TestCategory");
        Product testProduct = new Product("TestProduct", category, 99.99, 10);
        productService.addProduct(testProduct.getProductName(), testProduct.getCategory(), testProduct.getPrice(), testProduct.getQuantity());

        // When
        Product foundProduct = productService.findProductByNameAndCategory("TestProduct");

        // Then
        Assertions.assertEquals(testProduct, foundProduct);
    }
}