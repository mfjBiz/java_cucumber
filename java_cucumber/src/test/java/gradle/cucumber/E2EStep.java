package gradle.cucumber;

import cucumber.api.java.en.Given;
import static org.junit.Assert.assertEquals;

public class E2EStep {

    @Given("I visit top page")
    public void i_visit_top_page() {
        assertEquals(true, false);
    }

}
