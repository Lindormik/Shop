package ShopOnline.services;

import ShopOnline.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoryService {
    private final List<Category> categories;
    Category category1 = new Category("Komputery stacjonarne");
    Category category2 = new Category("Drukarki i skanery");
    Category category3 = new Category("Klawiatury");
    Category category4 = new Category("Monitory");
    Category category5 = new Category("Mikrofony");
    Category category6 = new Category("Słuchawki");
    Category category7 = new Category("Podzespoły komputerowe");
    Category category8 = new Category("Cześci do laptopów");
    Category category9 = new Category("Słuchawki");

    public CategoryService() {
        categories = new ArrayList<>();
    }

    public void addCategory(String name) {
        try {
            Category category = new Category(name);
            categories.get(category.getCategoryId());
            System.out.println("Dodano nową kategorię: " + category.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd dodawania kategorii: " + e.getMessage());
        }
    }

    public void removeCategory(int categoryId) {
        if (categories.contains(categoryId)) {
            categories.remove(categoryId);
            System.out.println("Usunięto kategorię o numerze: " + categoryId);
        } else {
            System.out.println("Kategoria o podanym numerze nie istnieje.");
        }
    }

    public List<Category> showAllCategories() {
        return categories;
    }

    public void showOneCategory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ID kategorii: ");
        int categorytId = scanner.nextInt();
        scanner.nextLine();

        Category category = findCategoryById(categorytId);
        if (category != null) {
            System.out.println(category);
        } else {
            System.out.println("Produkt o podanym ID nie został znaleziony.");
        }
    }
    public Category findCategoryById(int categoryID) {
        for (Category category: categories) {
            if (category.getCategoryId() == categoryID) {
                return category;
            }
        }
        return null;
    }
}

