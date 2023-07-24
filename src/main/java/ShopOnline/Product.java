package ShopOnline;

public class Product {
    private final int productID;
    private static int lastProductId = 0;
    private final String productName;
    private static Category category;
    private final double price;
    private final int quantity;

    public Product(String productName, Category category, double price, int quantity) {
        lastProductId++;
        this.productID = lastProductId;
        this.productName = validateProductName(productName);
        this.price = validatePrice(price);
        this.quantity = validateQuantity(quantity);
        Product.category = category;
    }

    @Override
    public String toString() {
        return "Nazwa produktu: " + productName +
                ", kategoria produktu: " + category.getName() +
                ", cena: " + price +
                ", ilość: " + quantity +
                ", ID produktu: " + productID;
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
        if (productName.length() == 0 || productName.length() >= 50) {
            throw new IllegalArgumentException("Pole Nazwa musi zawierać od 1 do 50 znaków");
        }
        if (!productName.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$")) {
            throw new IllegalArgumentException("Pole Nazwa musi zawierać znaki z alfabetu i cyfry");
        }
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

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public static Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
