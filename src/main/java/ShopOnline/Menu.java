package ShopOnline;

import ShopOnline.services.CategoryService;
import ShopOnline.services.ProductService;

import java.util.Scanner;

public class Menu extends ProductService {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    private final CategoryService categoryServiceService = new CategoryService();

    public void showMainMenu() {
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
//                case 2 -> showCategorySubMenu();
//                case 2 -> showOrderSubMenu();
                case 3 -> exit = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }

    public void showProductSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie produkty.");
            System.out.println("[2] Pokaż jeden produkt.");
            System.out.println("[3] Dodaj produkt.");
            System.out.println("[4] Cofnij");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> productService.showAllProducts();
                case 2 -> productService.showOneProduct();
                case 3 -> productService.addProduct();
                case 4 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }

            System.out.println();
        }
    }
}