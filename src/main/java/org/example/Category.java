package org.example;

public class Category {
    private int categoryId;
    private String name;

    public Category(String name) {
        this.name = name;
        this.categoryId++;
    }
}
