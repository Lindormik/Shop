package ShopOnline.services;

import ShopOnline.Category;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CategoryService {
    public static List<Category> categories = generateCategories();

    public static List<Category> generateCategories() {
        List<Category> categoryList = new ArrayList<>();

        Category category1 = new Category("Komputery stacjonarne");
        Category category2 = new Category("Drukarki i skanery");
        Category category3 = new Category("Klawiatury");
        Category category4 = new Category("Monitory");
        Category category5 = new Category("Mikrofony");
        Category category6 = new Category("Słuchawki");
        Category category7 = new Category("Podzespoły komputerowe");
        Category category8 = new Category("Cześci do laptopów");
        Category category9 = new Category("Słuchawki");

        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        categoryList.add(category5);
        categoryList.add(category6);
        categoryList.add(category7);
        categoryList.add(category8);
        categoryList.add(category9);

        return categoryList;
    }

    public void showAllCategories() {
        System.out.println("Lista produktów:");
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public void addCategory(String name) {
        Category category = new Category(name);
        categories.add(category);
        System.out.println("Dodano nową kategorię: " + category.getName());
    }

    public void removeCategory(int categoryId) {
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getCategoryId() == categoryId) {
                iterator.remove();
                System.out.println("Kategoria o identyfikatorze " + categoryId + " została usunięta.");
                return;
            }
        }
        System.out.println("Nie znaleziono kategorii o identyfikatorze " + categoryId + ".");
    }

    public String showOneCategory(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return "Kategoria o numerze: " + category.getCategoryId() + "\n" +
                        "Nazwa kategorii: " + category.getName();

            }
        }
        return "Kategoria o podanym numerze nie istnieje.";

    }

    public Category findOrCreateCategory(String name) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        }
        Category newCategory = new Category(name);
        categories.add(newCategory);
        return newCategory;
    }
}


