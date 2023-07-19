package ShopOnline;

import java.util.Random;

public class Category {
    private static int lastCategoryId = 0;
    private int categoryId;
    private final String name;

    public Category(String name) {
        lastCategoryId++;
        this.categoryId = lastCategoryId;
        this.name = name;
    }



    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return
                "ID Kategorii: " + getCategoryId() +
                ", Nazwa kategorii: " + getName()
                ;
    }
}
