package ShopOnline;

import java.util.Random;

public class Category {
    private static Random random = new Random();
    private int categoryId;
    private int nextCategoryId = 0;
    private final String name;

   /* public Category(int categoryId, String name) {
        this.categoryId = random.nextInt(0,11);
        this.name = name;
    }*/

    public Category(String name) {
        if (name == null || name.trim().isEmpty() || name.length() >= 50) {
            throw new IllegalArgumentException("Nazwa kategorii jest nieprawidłowa.");
        }
        this.name = name;
        this.categoryId = nextCategoryId;
        nextCategoryId++;
    }
    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}
