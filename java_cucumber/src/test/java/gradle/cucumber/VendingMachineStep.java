package gradle.cucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class VendingMachineStep {

    private VendingMachine vm;

    @Given("自動販売機がある")
    public void 自動販売機がある() {
        vm = new VendingMachine();
    }

    @And("^\"([^\"]*)\"を(\\d+)個追加する$")
    public void を個追加する(String name, int number) {
        vm.addDrink(name, number);
    }

    @When("^(\\d+)円を入金$")
    public void 円を入金(int money) {
        vm.charge(money);
    }

    @When("以下のお金を入金")
    public void 以下のお金を入金(DataTable dataTable) {
        dataTable.asLists().forEach(data->{
            vm.charge(Integer.valueOf(data.get(0)));
        });
    }

    @When("お釣りを返却")
    public void お釣りを返却() {}

    @Then("^(\\d+)円が入金されている$")
    public void 円が入金されている(int money) {
       assertEquals(Optional.ofNullable(money), Optional.ofNullable(vm.currentCharge()));
    }

    @Then("^(\\d+)円が返却される$")
    public void 円が返却される(int money) {
        assertEquals(money, vm.reset());
    }

    @Then("^\"([^\"]*)\"の在庫が(\\d+)個$")
    public void の在庫が個(String name, int number) {
        assertEquals(number, vm.inventorySizeBy(name));
    }

    @When("^\"([^\"]*)\"を購入$")
    public void を購入(String name) {
        vm.buy(name);
    }
}

