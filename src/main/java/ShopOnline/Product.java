package ShopOnline;

import java.util.Random;

public class Product extends Category {

    private static final Random random = new Random();
    private static int productID;
    private final String productName;
    private static Category category;
    private final double price;
    private final int quantity;

    public Product(String productName, String name, double price, int quantity) {
        super(name);
        this.productID = random.nextInt(0, 100);
        this.productName = validateProductName(productName);
        this.price = validatePrice(price);
        this.quantity = validateQuantity(quantity);
    }

    @Override
    public String toString() {
        return "Nazwa produktu: " + productName +
                ", kategoria produktu: " + category.getName() +
                ", cena: " + price +
                ", ilość: " + quantity;
    }

    private double validatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Cena musi być większa od 0");
        }
        return price;
    }

    private String validateProductName(String productName) {
        if (productName == null || productName.isBlank()) {
            throw new IllegalArgumentException("Pole Nazwa nie może być puste");
        }
        if (productName.length() <= 0 || productName.length() >= 50) {
            throw new IllegalArgumentException("Pole Nazwa musi zawierać od 1 do 50 znaków");
        }
//        if (!productName.matches("[a-zA-Z1-9]")) {
//            throw new IllegalArgumentException("Pole Nazwa musi zawierać znaki z alfabetu");
//        }
        return productName;
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

    public static Random getRandom() {
        return random;
    }

    public static int getProductID() {
        return productID;
    }

    public static void setProductID(int productID) {
        Product.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public static Category getCategory() {
        return category;
    }

    public static void setCategory(Category category) {
        Product.category = category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
