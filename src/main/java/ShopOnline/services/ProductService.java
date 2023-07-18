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

    public void addProduct(String name, double price, int quantity) {
        try {
            Product product = new Product(name, price, quantity);
            products.get(product.getProductID());
            System.out.println("Dodano nowy produkt: " + product.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd dodawania produktu: " + e.getMessage());
        }
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<Product> showAllProducts() {
        List<Product> products = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("ListOfProducts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    int productId = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    Category category = validateCategory(parts[2]);
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);

                    Product product = new Product(productId, name, category, price, quantity);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        try (BufferedReader reader = new BufferedReader(new FileReader("nazwa_pliku.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Przykład formatu danych w pliku: ID,Nazwa,Kategoria,Cena,Ilość
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int id = Integer.parseInt(parts[0]);
                    if (id == productId) {
                        String name = parts[1];
                        Category category = validateCategory(parts[2]);
                        double price = Double.parseDouble(parts[3]);
                        int quantity = Integer.parseInt(parts[4]);

                        return new Product(productId, name, category, price, quantity);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
