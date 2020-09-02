package sample;

import javafx.scene.control.CheckBox;

public class Product {
    private String name;
    private CheckBox need;
    private int quantity;

    public Product() {
        this.name = "";
        this.need = null;
        this.quantity = 0;
    }


    public Product(String name, int quantity) {
        this.name = name;
        this.need = new CheckBox();
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CheckBox getNeed() {
        return need;
    }

    public void setNeed(CheckBox need) {
        this.need = need;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
