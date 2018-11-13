package gradle.cucumber;

public class DrinkStock {

    private String drinkName;
    private int amount;

    public DrinkStock(String drinkName) {
        this.drinkName = drinkName;
    }

    public void addDrink(int amount) {
        this.amount += amount;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public int getAmount() {
        return amount;
    }
}
