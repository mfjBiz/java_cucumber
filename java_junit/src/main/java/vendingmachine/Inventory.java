package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public List<Drink> drinks;

    public Inventory() {
        this.drinks = new ArrayList<>();
    }

    public Inventory(List<Drink> drinks) {
        this.drinks = drinks;
    }

    boolean existBy(String name) {
        for (Drink drink : drinks) {
            if (name.equals(drink.name)) {
                return true;
            }
        }
        return false;
    }
}
