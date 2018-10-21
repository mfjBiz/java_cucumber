package vendingmachine;

public class ChargeBox {
    public int value;

    Integer reset() {
        Integer charge = value;
        value = 0;
        return charge;
    }

    void add(int money) {
        value += money;
    }

    void minus(int price ) {
        value = value - price;
    }
}
