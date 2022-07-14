package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import java.time.Duration;
import java.time.LocalDateTime;
import static pages.AlzaPage.*;
import static utilities.CommonActions.*;
import static utilities.Properties.loadProp;

public class Alza {
    WebDriver driver;
    String url;
    int defaultWait;

    public Alza(WebDriver driver){
        this.driver = driver;
        this.url = loadProp("WEB_PAGE");
        this.defaultWait = Integer.parseInt(loadProp("DEFAULT_WAIT"));
    }

    public void navigateToHomePage(){
        // navigate to web page, link is stored in config.properties
        Reporter.log(LocalDateTime.now() +": navigate to page: "+url);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(defaultWait));
        driver.manage().window().maximize();
        waitForFullPageLoad(driver, defaultWait);
    }

    public void acceptCookies() {
        waitForElementToBeVisible(driver, acceptCookies, defaultWait);
        clickElement(driver, acceptCookies);
    }

    public void addProductToBasket(By productBuyButton) {
        // add product to the basket and go back
        Reporter.log(LocalDateTime.now() +": adding product to basket");
        waitForElementClickable(driver, productBuyButton, defaultWait);
        clickElement(driver, productBuyButton);
        waitForFullPageLoad(driver, defaultWait);
        driver.navigate().back();
        waitForFullPageLoad(driver, defaultWait);
    }

    public void openMostExpensiveProducts() {
        // click on tab "most expensive products"
        Reporter.log(LocalDateTime.now() +": open most expensive products");
        waitForElementToBeVisible(driver, mostExpensiveLink, defaultWait);
        clickElement(driver,mostExpensiveLink);
        waitForElementToBeVisible(driver, productBoxes, defaultWait);
        waitForFullPageLoad(driver, defaultWait);
    }

    public void navigateToMobiles() {
        Reporter.log(LocalDateTime.now() +": navigate Smart devices and Phones");
        // navigate to category Smart devices and Phones
        waitForElementToBeVisible(driver, categorySmartLink, defaultWait);
        clickElement(driver, categorySmartLink);
        // navigate to subcategory Phones
        waitForElementToBeVisible(driver, mobilePhonesLink, defaultWait);
        clickElement(driver, mobilePhonesLink);
    }

    public void navigateToBasket() {
        Reporter.log(LocalDateTime.now() +": navigate Smart devices and Phones");
        // navigate to basket
        clickElement(driver, basketButton);
        waitForElementToBeVisible(driver, orderPage, defaultWait);
    }
}