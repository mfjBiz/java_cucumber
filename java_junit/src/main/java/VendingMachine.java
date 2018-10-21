import java.util.*;

public class VendingMachine {
    public List<Drink> drinks = new ArrayList<>();
    private int charge;

    public VendingMachine() {
        for (int i = 0; i < 5; i++) {
            drinks.add(new Drink("coke", 120));
        }
    }

    public VendingMachine charge(int money) {
        if (money == 10 || money == 50 || money == 100 || money == 500 || money == 1000) {
            this.charge += money;
        }
        return this;
    }

    public Integer currentCharge() {
        return charge;
    }

    public Integer resetCharge() {
        Integer charge = this.charge;
        this.charge = 0;
        return charge;
    }

    public String inventory() {
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

    public VendingMachine addDrink(String name, String price) {
        drinks.add(new Drink(name, Integer.parseInt(price)));
        return this;
    }

    public boolean canBy(String name) {
        boolean existInventory = false;
        for (Drink drink : drinks) {
            if (name == drink.name) {
                existInventory = true;
            }
        }
        if (existInventory == false) {
            return false;
        }
        for (Drink drink : drinks) {
            if (name == drink.name) {
                if (currentCharge() < Integer.valueOf(drink.price)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void buy(String name) {
        int price = 0;
        Iterator<Drink> drinkIterator = drinks.iterator();
        while (drinkIterator.hasNext()) {
            Drink drink = drinkIterator.next();
            if (drink.name == name) {
                price = drink.price;
                drinkIterator.remove();
                break;
            }
        }

        charge = currentCharge() - price;
    }
}
