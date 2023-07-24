package ShopOnline.services;

import ShopOnline.Category;
import ShopOnline.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {
    public static List<Product> products = generateProducts();

    public static List<Product> generateProducts() {
        List<Product> productList = new ArrayList<>();


        Product product1 = new Product("Produkt1", CategoryService.categories.get(1), 874.32, 6);
        Product product2 = new Product("Produkt2", CategoryService.categories.get(2), 1293.19, 9);
        Product product3 = new Product("Produkt3", CategoryService.categories.get(5), 672.44, 2);
        Product product4 = new Product("Produkt4", CategoryService.categories.get(2), 1068.53, 3);
        Product product5 = new Product("Produkt5", CategoryService.categories.get(3), 531.72, 7);
        Product product6 = new Product("Produkt6", CategoryService.categories.get(4), 1155.87, 111);
        Product product7 = new Product("Produkt7", CategoryService.categories.get(5), 746.99, 5);
        Product product8 = new Product("Produkt8", CategoryService.categories.get(6), 924.28, 4);
        Product product9 = new Product("Produkt9", CategoryService.categories.get(7), 1254.11, 122);
        Product product10 = new Product("Produkt10", CategoryService.categories.get(8), 1036.6, 8);
        Product product11 = new Product("Produkt11", CategoryService.categories.get(0), 756.25, 6);
        Product product12 = new Product("Produkt12", CategoryService.categories.get(2), 801.87, 9);
        Product product13 = new Product("Produkt13", CategoryService.categories.get(1), 679.52, 3);

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

    public void showAllProducts() {
        System.out.println("Lista produktów:");
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }

    public void addProduct(String productName, Category category, double price, int quantity) {
        Product product = new Product(productName, category, price, quantity);
        products.add(product);
        System.out.println("Dodano nowy produkt: " + product.getProductName());

    }

    public void removeProductByID(int productID) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductID() == productID) {
                iterator.remove();
                System.out.println("Produkt o identyfikatorze " + productID + " został usunięty.");
                return;
            }
        }
        System.out.println("Nie znaleziono produktu o identyfikatorze " + productID + ".");
    }

    public void showOneProduct(int productId) {
        for (Product product : products) {
            if (product.getProductID() == productId) {
                System.out.println("Produkt o numerze: " + product.getProductID());
                System.out.println("Nazwa produktu: " + product.getProductName());
                return;
            }
        }
        System.out.println("Produkt o podanym numerze nie istnieje.");
    }

    public Product findProductByNameAndCategory(String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product findProductById(int productId) {
        for (Product product : products) {
            if (product.getProductID() == productId) {
                return product;
            }
        }
        return null;
    }
}
