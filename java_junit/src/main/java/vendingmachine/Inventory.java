package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Drink> drinks;

    Inventory() {
        this.drinks = new ArrayList<>();
    }

    void add(Drink drink) {
        drinks.add(drink);
    }

    boolean existBy(String name) {
        for (Drink drink : drinks) {
            if (name.equals(drink.name)) {
                return true;
            }
        }
        return false;
    }

    boolean canBuy(String name, Integer currentCharge) {
        for (Drink drink : drinks) {
            if (name.equals(drink.name)) {
                if (currentCharge < drink.price) {
                    return true;
                }
            }
        }
        return false;
    }
}
