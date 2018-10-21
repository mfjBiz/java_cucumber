package vendingmachine;

class Drink {
    final String name;
    final int price;

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String info() {
        return name + " " + price + "yen: ";
    }
}
