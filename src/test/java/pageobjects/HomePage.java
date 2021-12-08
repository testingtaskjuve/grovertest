package pageobjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    WebDriverWait  wait;// special object to wait elements

    private By searchField = By.xpath("//input[@class='wfhkog-3 LCKRU']");

    private By productItem = By.xpath("//div[@class='verticalStyles__CardWrapper-sc-1je3l7s-10 godjZQ']");

    /**
     * This is constructor for HomePage class to create driver
     * and wait objects to use for all methods inside this class
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;

        wait = new WebDriverWait(driver, 20);
    }

    /**
     * This method type search text and click enter to star searching
     * @param searchText
     */
    public void typeSearchTextAndClickSearch(String searchText){
        driver.findElement(searchField).sendKeys(searchText);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
    }

    /**
     * This method should check that result of searching is not empty after 20 seconds awaiting
     */
    public void searchResultIsNotEmpty() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(productItem));
        } catch (Exception ex) {
            System.out.println("Search result doesn't contain any items after awaiting");
        }
        Assert.assertTrue("result is empty",driver.findElements(productItem).size() > 0);
    }

    /**
     * This method wait at least one element as a result of searching to choose
     */
    public void chooseFirstItem() {
        wait.until(ExpectedConditions.elementToBeClickable(productItem));
        driver.findElement(productItem).click();
    }
}
