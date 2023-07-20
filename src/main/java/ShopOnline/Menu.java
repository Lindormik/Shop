package ShopOnline;


import ShopOnline.services.CategoryService;
import ShopOnline.services.ProductService;
import ShopOnline.services.OrderService;


import java.util.Map;
import java.util.Scanner;

import static ShopOnline.services.CategoryService.generateCategories;
import static ShopOnline.services.ProductService.generateProducts;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductService productService = new ProductService();
    private final CategoryService categoryServiceService = new CategoryService();
    private final OrderService orderService = new OrderService();

    public void showMainMenu() {
        generateProducts();
        generateCategories();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Produkt");
            System.out.println("2. Kategoria");
            System.out.println("3. Zamówienia");
            System.out.println("4. Wyjdź");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> showProductSubMenu();
                case 2 -> showCategorySubMenu();
                case 3 -> showOrderSubMenu();
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
            System.out.println("[2, ID Produktu] Pokaż wybrany produkt.");
            System.out.println("[3,Nazwa produktu, Kategoria produktu, Cena produktu, Ilosc produktu] Dodaj produkt.");
            System.out.println("[4, ID Produktu] Usuń wybrany produkt.");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1 -> productService.showAllProducts();
                case 2 -> productService.showOneProduct(Integer.parseInt(words[1]));
                case 3 -> {
                    String productName = words[1];
                    Category category = categoryServiceService.findOrCreateCategory(words[2]);
                    double price = Double.parseDouble(words[3]);
                    int quantity = Integer.parseInt(words[4]);
                    productService.addProduct(productName, category, price, quantity);
                }
                case 4 -> productService.removeProductByID(Integer.parseInt(words[1]));
                case 5 -> back = true;
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
            System.out.println("[4, ID Kategorii] Usuń wybraną kategorię.");
            System.out.println("[5] Cofnij");
            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();
            switch (Integer.parseInt(words[0])) {
                case 1 -> categoryServiceService.showAllCategories();
                case 2 -> categoryServiceService.showOneCategory(Integer.parseInt(words[1]));
                case 3 -> categoryServiceService.addCategory(words[1]);
                case 4 -> categoryServiceService.removeCategory(Integer.parseInt(words[1]));
                case 5 -> back = true;
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }

    public void showOrderSubMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("[1] Pokaż wszystkie zamówienia.");
            System.out.println("[2, ID Zamówienia] Pokaż wybrane zamówienie.");
            System.out.println("[3,Nazwa produktu, Kategoria produktu, Cena produktu, Ilosc produktu] Dodaj zamówienie.");
            System.out.println("[4, ID Zamówienia, Nowy status] Zmień status zamówienia");
            System.out.println("[5] Cofnij");

            String choice = scanner.next();
            String[] words = choice.split(",");
            scanner.nextLine();

            switch (Integer.parseInt(words[0])) {
                case 1:
                    orderService.showAllOrders();
                    break;
                case 2:
                    orderService.showSelectedOrder(Integer.parseInt(words[1]));
                    break;
                case 3:
                    String clientName = words[1];
                    String clientSurname = words[2];
                    String clientAddress = words[3];
                    int productId = Integer.parseInt(words[4]);
                    int quantity = Integer.parseInt(words[5]);
                    double orderSum = Double.parseDouble(words[6]);
                    orderService.addOrder(clientName,clientSurname,clientAddress,orderSum,productId,quantity);
                    break;

                case 4:
                    int orderId = Integer.parseInt(words[1]);
                    String newStatusString = words[2];
                    OrderStatus newStatus;
                    try {
                        newStatus = OrderStatus.valueOf(newStatusString.toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Nieprawidłowy status zamówienia.");
                        return;
                    }
                    orderService.changeOrderStatus(orderId, newStatus);
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            System.out.println();
        }
    }
}
