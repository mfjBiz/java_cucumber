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
        return drinks.stream().anyMatch(drink -> drink.name.equals(name));
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

    int buyBy(String name) {
        if (!existBy(name)) {
            return 0;
        }
        Drink drink = findBy(name);
        removeBy(name);
        return drink.price;
    }

    private void removeBy(String name) {
        drinks.stream()
                .filter(drink -> drink.name.equals(name))
                .findFirst()
                .map(drink -> drinks.remove(drink));
    }

    private Drink findBy(String name) {
        return drinks.stream()
                .filter(drink -> drink.name.equals(name))
                .findFirst()
                .get();
    }
}
