package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class StepDefinitions {

    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void SetUp(){
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @After
    public void Quit(){
        driver.quit();
    }

    public WebElement findElementWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public List<WebElement> findElementsWithWait(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    @Given("Navigate to url")
    public void navigate_to_url() {
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }
    @When("Click on the button �Bank Manager Login�")
    public void click_on_the_button_bank_manager_login() {
        findElementWithWait(By.xpath("//button[@class= 'btn btn-primary btn-lg']")).click();

    }
    @When("Click on the button �Customers�")
    public void click_on_the_button_customers() {
        findElementWithWait(By.xpath("//button[@ng-click= 'showCust()']")).click();;

    }
    @When("Get the number of records in the table")
    public void get_the_number_of_records_in_the_table() {
        List<WebElement> records= findElementWithWait(By.xpath("//span[@class-repeat='ang-binding ng-scope', '1001 1002 1003, '1004 1005 1006', '1007 1008 1009', '1007 1008 1009'; '1010 1011 1012','1013 1014 1015']"));
        records.size();

    }
    @When("Remove {int} of them")
    public void remove_of_them(Integer int1) {
        List<WebElement>records= findElementsWithWait(By.xpath("//span[@class-repeat='ang-binding ng-scope', '1001 1002 1003, '1004 1005 1006', '1007 1008 1009', '1007 1008 1009'; '1010 1011 1012','1013 1014 1015']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(records.get(1)).perform();

    }
    @Then("Verify there are {int} records left")
    public void verify_there_are_records_left(Integer int1) {
        List<WebElement> records= findElementWithWait(By.xpath("//span[@class-repeat='ang-binding ng-scope', '1001 1002 1003, '1004 1005 1006', '1007 1008 1009', '1007 1008 1009'; '1010 1011 1012','1013 1014 1015']"));
        records.size();

       // ???
    }
}
