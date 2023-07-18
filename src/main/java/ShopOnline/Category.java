package ShopOnline;

public class Category {
    private int categoryId;
    private String name;

    public Category(String name) {
        if (name == null || name.trim().isEmpty() || name.length() >= 50) {
            throw new IllegalArgumentException("Nazwa kategorii jest nieprawidłowa.");
        }
        this.name = name;
        this.categoryId++;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}
