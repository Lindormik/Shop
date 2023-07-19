package ShopOnline;


import ShopOnline.services.CategoryService;
import ShopOnline.services.ProductService;

import java.util.Scanner;
import static ShopOnline.services.CategoryService.generateCategories;
import static ShopOnline.services.ProductService.generateProducts;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    private final CategoryService categoryServiceService = new CategoryService();

    public void showMainMenu() {
        generateProducts();
        generateCategories();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Produkt");
            System.out.println("2. Kategoria");
            System.out.println("3. Zamówienia");
            System.out.println("3. Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showProductSubMenu();
                case 2 -> showCategorySubMenu();
//                case 2 -> showOrderSubMenu();
                case 4 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie produkty.");
            System.out.println("[2, ID Produktu] Pokaż jeden produkt.");
            System.out.println("[3,Nazwa produktu, Kategoria produktu, Cena produktu, Ilosc produktu] Dodaj produkt.");
            System.out.println("[4] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> productService.showAllProducts();
                case 2 -> productService.showOneProduct(Integer.parseInt(words[1]));
                case 3 ->  {
                    String productName = words[1];
                    Category category = categoryServiceService.findOrCreateCategory(words[2]);
                    double price = Double.parseDouble(words[3]);
                    int quantity = Integer.parseInt(words[4]);
                    productService.addProduct(productName, category, price, quantity);
                }
                case 4 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showCategorySubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie kategorie.");
            System.out.println("[2,IdKategorii] Pokaż wybraną kategorie.");
            System.out.println("[3,Nazwa kategorii] Dodaj kategorie.");
            System.out.println("[4] Cofnij");
            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();
            switch (Integer.parseInt(words[0])) {
                case 1 -> categoryServiceService.showAllCategories();
                case 2 -> categoryServiceService.showOneCategory(Integer.parseInt(words[1]));
                case 3 -> categoryServiceService.addCategory(words[1]);
                case 4 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

}
