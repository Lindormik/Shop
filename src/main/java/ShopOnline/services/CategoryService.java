package ShopOnline.services;

import ShopOnline.Category;
import ShopOnline.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if (categories.contains(categoryId)) {
            categories.remove(categoryId);
            System.out.println("Usunięto kategorię o numerze: " + categoryId);
        } else {
            System.out.println("Kategoria o podanym numerze nie istnieje.");
        }
    }


    public void showOneCategory(int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                System.out.println("Kategoria o numerze: " + category.getCategoryId());
                System.out.println("Nazwa kategorii: " + category.getName());
                return;
            }
        }
        System.out.println("Kategoria o podanym numerze nie istnieje.");
    }


    public Category findOrCreateCategory(String name) {
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(name)) {
                return category;
            }
        } Category newCategory = new Category(name);
        categories.add(newCategory);
        return newCategory;}}


