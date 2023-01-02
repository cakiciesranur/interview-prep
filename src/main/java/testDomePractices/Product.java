package testDomePractices;

public class Product {

    public String name;
    public int quantity;

    public Product(String name) {
        this.name = name;
        this.quantity = 1;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 1) {
            this.quantity = 1;
        } else {
            this.quantity = quantity;
        }
    }
}