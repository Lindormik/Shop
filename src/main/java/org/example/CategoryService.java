package org.example;

import java.util.HashMap;
import java.util.Map;

public class CategoryService {
    private final Map<Integer, Category> categories;

    public CategoryService() {
        categories = new HashMap<>();
    }

    public void dodajKategorie(String name) {
        try {
            Category category = new Category(name);
            categories.put(category.getCategoryId(), category);
            System.out.println("Dodano nową kategorię: " + category.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd dodawania kategorii: " + e.getMessage());
        }
    }

    public void usunKategorie(int categoryId) {
        if (categories.containsKey(categoryId)) {
            categories.remove(categoryId);
            System.out.println("Usunięto kategorię o numerze: " + categoryId);
        } else {
            System.out.println("Kategoria o podanym numerze nie istnieje.");
        }
    }

    public void pokazWszystkieKategorie() {
        if (!categories.isEmpty()) {
            System.out.println("Lista kategorii:");
            for (Category category : categories.values()) {
                System.out.println("Kategoria #" + category.getCategoryId() + ": " + category.getName());
            }
        } else {
            System.out.println("Brak kategorii.");
        }
    }

    public void pokazWybranaKategorie(int categoryId) {
        Category category = categories.get(categoryId);
        if (category != null) {
            System.out.println("Kategoria #" + category.getCategoryId() + ": " + category.getName());
        } else {
            System.out.println("Kategoria o podanym numerze nie istnieje.");
        }
    }
}

