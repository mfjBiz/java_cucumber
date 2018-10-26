package gradle.cucumber.blog;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

import static org.testng.Assert.assertEquals;

public class BlogStep {

    private ChromeDriver driver = new WebDriverWrapper().getDriver();


    @Given("^ブログ登録ページに遷移$")
    public void ブログ登録ページに遷移() {
        driver.get("http://localhost:8080/blogs");
        assertEquals("blogs",driver.findElementById("blogs").getText());
        driver.close();
    }

    @When("^以下のブログ情報を入力して登録$")
    public void 以下のブログ情報を入力して登録(Map<String, String> form) {
        assertEquals(form.get("タイトル"), "バーニーズマウンテンドッグが家にきた");
    }

    @Then("^登録した記事が表示されている$")
    public void 登録した記事が表示されている() {
    }
}
