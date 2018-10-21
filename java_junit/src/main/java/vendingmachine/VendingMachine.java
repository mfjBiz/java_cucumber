package vendingmachine;

import java.util.List;

class VendingMachine {
    Inventory inventory;
    private int charge;

    VendingMachine() {
        inventory = new Inventory();
        for (int i = 0; i < 5; i++) {
            inventory.add(new Drink("coke", 120));
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
        return inventory.info();
    }

    VendingMachine addDrink(String name, String price) {
        inventory.add(new Drink(name, Integer.parseInt(price)));
        return this;
    }

    boolean canBy(String name) {
        if (!inventory.existBy(name)) {
            return false;
        }
        Integer currentCharge = currentCharge();
        return !inventory.canBuy(name, currentCharge);
    }

    void buy(String name) {
        int price = inventory.buyBy(name);
        charge = currentCharge() - price;
    }

}
