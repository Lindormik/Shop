package ShopOnline.services;

import ShopOnline.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    public static List<Product> products = generateProducts();

    public static List<Product> generateProducts() {
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("Produkt1", "Komputery stacjonarne", 874.32, 6);
        Product product2 = new Product("Produkt2", "Drukarki i skanery", 1293.19, 9);
        Product product3 = new Product("Produkt3", "Klawiatury", 672.44, 2);
        Product product4 = new Product("Produkt4", "Monitory", 1068.53, 3);
        Product product5 = new Product("Produkt5", "Mikrofony", 531.72, 7);
        Product product6 = new Product("Produkt6", "Słuchawki", 1155.87, 111);
        Product product7 = new Product("Produkt7", "Laptopy", 746.99, 5);
        Product product8 = new Product("Produkt8", "Podzespoły komputerowe", 924.28, 4);
        Product product9 = new Product("Produkt9", "Części do laptopów", 1254.11, 122);
        Product product10 = new Product("Produkt10", "Słuchawki", 1036.6, 8);
        Product product11 = new Product("Produkt11", "Komputery stacjonarne", 756.25, 6);
        Product product12 = new Product("Produkt12", "Drukarki i skanery", 801.87, 9);
        Product product13 = new Product("Produkt13", "Monitory", 679.52, 3);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);
        productList.add(product11);
        productList.add(product12);
        productList.add(product13);

        return productList;
    }
   /* public ProductService() {
        products = new ArrayList<>();
    }*/

    public void addProduct(String productName, String name, double price, int quantity) {
        try {
            Product product = new Product(productName, name, price, quantity);
            products.get(product.getProductID());
            System.out.println("Dodano nowy produkt: " + product.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd dodawania produktu: " + e.getMessage());
        }
    }

    public void deleteProduct(Product product) {
        products.remove(product);
    }
    public void showAllProducts() {
        System.out.println("Lista produktów:");
        for (Product product : products) {
            System.out.println(product);
        }



 /*   public void showOneProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ID produktu: ");
        int productID = scanner.nextInt();
        scanner.nextLine();*/

     /*   Product product = findProductById(productID);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Produkt o podanym ID nie został znaleziony.");
        }*/
    }

    public void
    findProductById(int productID) {
        for (Product product : products) {
            if (product.getProductID() == productID) {
                System.out.println(product);
            }
        }
        }

}
