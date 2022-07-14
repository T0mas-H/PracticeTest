import io.github.bonigarcia.wdm.WebDriverManager;
import modules.Alza;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AlzaPage;
import java.time.LocalDateTime;

public class PracticeTest {
    private WebDriver driver;

    @Test
    public void exercise_1(){
        for (int i = 100; i > 0; i--){
            // it could be printed inside of if else, however I decided to assigned it to value
            // and print it to console and reporter later
            String reportValue = "";
            if(i%5 == 0 && i%3 == 0){
                reportValue = "Testing";
            }
            else if(i%5 == 0){
                reportValue = "Agile";
            }
            else if(i%3 == 0){
                reportValue = "Software";
            }
            else{
                reportValue = String.valueOf(i);
            }
            Reporter.log(reportValue, true);
        }
    }

    @Test
    public void exercise_2() throws InterruptedException {
            Alza alza = new Alza(driver);
            alza.navigateToHomePage();
            alza.acceptCookies();
            alza.navigateToMobiles();
            alza.openMostExpensiveProducts();
            alza.addProductToBasket(AlzaPage.getProductBox_BuyButton(1));
            alza.addProductToBasket(AlzaPage.getProductBox_BuyButton(2));
            alza.navigateToBasket();
    }

    @BeforeTest
    void setup(){
        Reporter.log(LocalDateTime.now() +": starting WebDriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    void tearDown(){
        Reporter.log(LocalDateTime.now() +": closing WebDriver");
        driver.close();
    }
}
