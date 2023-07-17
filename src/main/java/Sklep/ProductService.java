package Sklep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<Product> showAllProducts() {
        return products;
    }

    public Product showOneProduct(int productId) {
        for (Product product : products) {
            if (product.getProductID() == productId) {
                return product;
            }
        }
        return null;
    }

    public void loadProductsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = parseProductFromLine(line);
                if (product != null) {
                    products.add(product);
                }
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }
    }

    private Product parseProductFromLine(String line) {
        String[] parts = line.split(";");



        if (parts.length == 5) {
            try {
                int productId = Integer.parseInt(parts[0]);
                String name = parts[1];
                //Category category = Category.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);

                //return new Product(productId, name, category, price, quantity);
            } catch (IllegalArgumentException e) {
                System.err.println("Błąd podczas parsowania linii: " + line);
            }
        }
        return null;
    }
}
