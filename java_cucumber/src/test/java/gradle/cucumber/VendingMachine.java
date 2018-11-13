package gradle.cucumber;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VendingMachine {

    private int money;
    private Map<String, DrinkStock> drinkStockMap = new HashMap<>();
    private static final Set<Integer> IGNORE_MONEY = new HashSet<>(Arrays.asList(1, 5, 2000, 5000, 10000));

    public void charge(int money) {
        if (IGNORE_MONEY.contains(money)) {
            return;
        }
        this.money += money;
    }

    public int currentCharge() {
        return this.money;
    }

    public void buy(int price) {
        this.money -= price;
    }

    public int returnChange() {
        int change = money;
        this.money = 0;
        return change;
    }

    public void addDrink(String drinkName, int amount) {
        DrinkStock drinkStock = drinkStockMap.get(drinkName);
        if (drinkStock == null) {
            drinkStock = new DrinkStock(drinkName);
            drinkStockMap.put(drinkName, drinkStock);
        }
        drinkStock.addDrink(amount);
    }

    public DrinkStock getStock(String drinkName) {
        return drinkStockMap.get(drinkName);
    }
}
