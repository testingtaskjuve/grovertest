package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;

public class HomePageSteps {
    BeforeAndAfterTestSteps beforeAndAfterTestSteps;
    WebDriver driver = beforeAndAfterTestSteps.getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("^start page is opened$")
    public void startPageIsOpened() throws Throwable {
        driver.get("https://www.grover.com/us-en");
    }

    @When("^type \"([^\"]*)\" into search field and click search$")
    public void typeIntoSearchFieldAndClickSearch(String productName) throws Throwable {
        homePage.typeSearchTextAndClickSearch(productName);
    }

    @Then("^this product is found$")
    public void thisProductIsFound() throws Throwable {
        homePage.searchResultIsNotEmpty();
    }

    @And("^choose first product in the list$")
    public void chooseFirstProductInTheList() throws Throwable {
        homePage.chooseFirstItem();
    }
}
