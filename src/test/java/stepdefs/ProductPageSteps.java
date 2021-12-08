package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobjects.ProductPage;

public class ProductPageSteps {
    BeforeAndAfterTestSteps beforeAndAfterTestSteps;
    WebDriver driver = beforeAndAfterTestSteps.getDriver();
    ProductPage productPage = new ProductPage(driver);


    @And("^add this product to basket$")
    public void addThisProductToBasket() throws Throwable {
        productPage.clickAddToCartButton();
    }

    @Then("^basket counter is updated$")
    public void basketCounterIsUpdated() throws Throwable {
        productPage.basketCounterIsUpdated();
    }
}
