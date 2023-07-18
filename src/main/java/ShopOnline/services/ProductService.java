package ShopOnline.services;

import ShopOnline.Category;
import ShopOnline.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
    }

//    public void addProduct() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Podaj ID produktu: ");
//        int productId = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.print("Podaj nazwę produktu: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Podaj kategorię produktu: ");
//        String category = scanner.nextLine();
//
//        System.out.print("Podaj cenę produktu: ");
//        double price = scanner.nextDouble();
//        scanner.nextLine();
//
//        System.out.print("Podaj ilość produktu: ");
//        int quantity = scanner.nextInt();
//        scanner.nextLine();
//
//        Product product = new Product(productId, name, category, price, quantity);
//        addProduct(product);
//        System.out.println("Produkt został dodany.");
//    }


    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<Product> showAllProducts() {
        return products;
    }

    public void showOneProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ID produktu: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        Product product = findProductById(productId);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Produkt o podanym ID nie został znaleziony.");
        }
    }
    public Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
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
                Category category = Category.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                int quantity = Integer.parseInt(parts[4]);

                return new Product(productId, name, category, price, quantity);
            } catch (IllegalArgumentException e) {
                System.err.println("Błąd podczas parsowania linii: " + line);
            }
        }
        return null;
    }
}