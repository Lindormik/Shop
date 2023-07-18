package ShopOnline;

import java.util.Random;

public class Product {

    private Random random = new Random();

    private int productID;
    private String name;
    private Category category;
    private double price;
    private int quantity;

    public Product(int productID, String name, Category category, double price, int quantity) {
        this.productID = random.nextInt(0,100);
        this.price = validatePrice(price);
        this.name = validateName(name);
        this.category = validateCategory(category);
        this.quantity = validateQuantity(quantity);
    }

    private double validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od 0");
        }
        return price;
    }

    private String validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Pole Imię nie może być puste");
        }
        if (name.length() <= 0 || name.length() >= 50) {
            throw new IllegalArgumentException("Pole Imię musi zawierać od 1 do 50 znaków");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Pole Imię musi zawierać znaki z alfabetu");
        }
        return name;
    }

    private Category validateCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Pole Kategoria nie może być puste");
        }
        return category;
    }

    private int validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Ilość musi być większa od 0");
        }
        return quantity;
    }

    public int getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = validatePrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateName(name);
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = validateCategory(category);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = validateQuantity(quantity);
    }
}
