package Cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
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
    public int beforeDelete;
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
    @When("Click on the button Bank Manager Login")
    public void click_on_the_button_bank_manager_login() {
        findElementWithWait(By.xpath("//button[contains(text(),'Bank Manager Login')]")).click(); // you weren't navigating to the right button

    }
    @When("Click on the button Customers")
    public void click_on_the_button_customers() {
        findElementWithWait(By.xpath("//button[contains(text(),'Customers')]")).click();

    }
    @When("Get the number of records in the table")
    public void get_the_number_of_records_in_the_table() {
        List<WebElement> rowsBefore = findElementsWithWait(By.xpath("//tbody/tr"));
        beforeDelete = rowsBefore.size();

    }
    @When("Remove {int} of them")
    public void remove_of_them(Integer int1) {
        List<WebElement> deleteButtons = findElementsWithWait(By.xpath("//button[contains(text(),'Delete')]"));
        for (int i=0; i<int1; i++) // the way you made it you wanted to have options to delete more than one entry if needed. So it is done with a loop
        deleteButtons.get(i).click();

    }
    @Then("Verify there are {int} records left")
    public void verify_there_are_records_left(Integer int1) {
        List<WebElement> rowsAfter = findElementsWithWait(By.xpath("//tbody/tr"));
        int afterDelete = rowsAfter.size();
        Assertions.assertEquals(int1, afterDelete);

    }
}
