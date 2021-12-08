package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;

    WebDriverWait wait;

    private By addToCartButton = By.xpath("//button[@class='stylesweb__Btn-sc-8t7679-0 hTXLqq " +
            "styles__RippleSurface-sc-8egglk-0 kGjPSD subscribe_cta']");

    private By basketCounter = By.xpath("//span[@class='styles__Counter-sc-1hop3y3-1 inDFNC']");

    /**
     * This is constructor for ProductPage class to create driver
     * and wait objects to use for all methods inside this class
     * @param driver
     */
    public ProductPage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, 20);
    }

    /**
     * This method adds product to cart
     */

    public void clickAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    /**
     * This method checks that cart is not empty
     */
    public void basketCounterIsUpdated() {
        wait.until(ExpectedConditions.presenceOfElementLocated(basketCounter));
        Assert.assertEquals("actual count doesn't equal to 1",
                "1", driver.findElement(basketCounter).getText());

    }
}
