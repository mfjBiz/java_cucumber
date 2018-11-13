package gradle.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class VendingMachineStep {

    VendingMachine vm;

    @Given("自動販売機がある")
    public void 自動販売機がある() {
        vm = new VendingMachine();
    }

    @When("^(\\d+)円を入金$")
    public void 円を入金(int money) throws Throwable {
        vm.charge(money);
    }

    @When("以下のお金を入金")
    public void 以下のお金を入金(DataTable dataTable) {
        List<Integer> objects = dataTable.asList(Integer.class);
        for (Integer money : objects) {
            vm.charge(money);
        }
    }

    @When("^(\\d+)円のジュースを購入する")
    public void 円のジュースを購入する(int price) {
        vm.buy(price);
    }

    @When("お釣りを返却する")
    public void お釣りを返却する() {
        vm.returnChange();
    }

    @When("(\\S+)を(\\d+)つ補充する")
    public void を_つ補充する(String drinkName, int amount) {
        vm.addDrink(drinkName, amount);
    }

    @Then("^(\\d+)円が入金されている$")
    public void 円が入金されている(int money) throws Throwable {
        assertEquals(money, vm.currentCharge());
    }

    @Then("^(\\d+)円のお釣りが返却される")
    public void 円のお釣りが返却される(int money) {
        assertEquals(money, vm.returnChange());
    }

    @Then("(\\S+)が(\\d+)つ在庫にある")
    public void が_つ在庫にある(String drinkName, int amount) {
        DrinkStock drinkStock = vm.getStock(drinkName);
        assertEquals(drinkName, drinkStock.getDrinkName());
        assertEquals(amount, drinkStock.getAmount());
    }
}
