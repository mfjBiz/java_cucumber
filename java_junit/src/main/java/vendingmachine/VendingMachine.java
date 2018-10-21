package vendingmachine;

import java.util.*;

class VendingMachine {
    List<Drink> drinks = new ArrayList<>();
    private int charge;

    VendingMachine() {
        for (int i = 0; i < 5; i++) {
            drinks.add(new Drink("coke", 120));
        }
    }

    VendingMachine charge(int money) {
        if (money == 10 || money == 50 || money == 100 || money == 500 || money == 1000) {
            this.charge += money;
        }
        return this;
    }

    Integer currentCharge() {
        return charge;
    }

    Integer resetCharge() {
        Integer charge = this.charge;
        this.charge = 0;
        return charge;
    }

    String inventory() {
        Map<String, List<String>> map = new HashMap<>();
        for (Drink drink : drinks) {
            if (map.containsKey(drink.name)) {
                String size = map.get(drink.name).get(1);
                int sizeInt = Integer.valueOf(size);
                sizeInt++;
                map.put(drink.name, Arrays.asList(String.valueOf(drink.price), String.valueOf(sizeInt)));
            } else {
                map.put(drink.name, Arrays.asList(String.valueOf(drink.price), "1"));
            }
        }
        List<String> result = new ArrayList<>();
        map.forEach((k, v) -> {
            result.add((k + " " + v.get(0) + "yen: " + v.get(1)));
        });
        return String.join("\n", result);
    }

    VendingMachine addDrink(String name, String price) {
        drinks.add(new Drink(name, Integer.parseInt(price)));
        return this;
    }

    boolean canBy(String name) {
        boolean existInventory = false;
        for (Drink drink : drinks) {
            if (name.equals(drink.name)) {
                existInventory = true;
            }
        }
        if (!existInventory) {
            return false;
        }
        for (Drink drink : drinks) {
            if (name.equals(drink.name)) {
                if (currentCharge() < drink.price) {
                    return false;
                }
            }
        }
        return true;
    }

    void buy(String name) {
        int price = 0;
        Iterator<Drink> drinkIterator = drinks.iterator();
        while (drinkIterator.hasNext()) {
            Drink drink = drinkIterator.next();
            if (drink.name.equals(name)) {
                price = drink.price;
                drinkIterator.remove();
                break;
            }
        }
        charge = currentCharge() - price;
    }
}
