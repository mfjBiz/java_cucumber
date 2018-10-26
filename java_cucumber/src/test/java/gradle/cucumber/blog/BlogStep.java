package gradle.cucumber.blog;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlogStep {

    private ChromeDriver driver = new WebDriverWrapper().getDriver();

    //driver.get("file:///Users/d.kanai/Desktop/hello.html");
    //assertEquals("hello",driver.findElementById(id).getText());
    //driver.close();

    @Given("^ブログ登録ページに遷移$")
    public void ブログ登録ページに遷移() {
    }

    @When("^以下のブログ情報を入力して登録$")
    public void 以下のブログ情報を入力して登録() {
    }

    @Then("^登録した記事が表示されている$")
    public void 登録した記事が表示されている() {
    }
}
