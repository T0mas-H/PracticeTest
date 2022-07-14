package pages;

import org.openqa.selenium.By;

public class AlzaPage {
    public static final By acceptCookies     = By.xpath("//a[contains(@class,'accept')]");
    public static final By categorySmartLink = By.xpath("//a[@href='/mobily-smart-hodinky-tablety']");
    public static final By mobilePhonesLink  = By.xpath("//div[@class='category-tree']//a[contains(@href,'/mobily/')]");
    public static final By mostExpensiveLink = By.xpath("//a[@href='#cenadesc']");
    public static final By productBoxes      = By.xpath("//div[@id='boxes']/div");
    public static final By basketButton      = By.xpath("//div[@id='basket']");
    public static final By orderPage         = By.xpath("//div[@id='orderpage']");

    public static By getProductBox_BuyButton(int index){
        return By.xpath(String.format("//div[@id='boxes']/div[%d]//a[@data-lb-action]",index));
    }
}
