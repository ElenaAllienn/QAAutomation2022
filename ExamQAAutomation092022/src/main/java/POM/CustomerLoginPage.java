package POM;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CustomerLoginPage extends BaseClass{
    public CustomerLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, new WebDriverWait(driver, Duration.ofSeconds(30)));
    }

    public void NavigateToUrl(){
        Driver().navigate().to(environment+ "/customer");
    }

    public void Login(){
        findElementWithWait(By.xpath("//button[@class ='btn btn-primary btn-lg']")).click();

    }

    public void SelectMenu() {
        // WebDriver driver; tou already have id instantiated
        findElementWithWait(By.id("userSelect")).click(); // always better with the wait method
        findElementWithWait(By.xpath("//option[contains(text(),'Harry Potter')]")).click(); // here just find by Harry's name

    }

    public void Btn(){
        findElementWithWait(By.xpath("//button[@type='submit']")).click();
        findElementWithWait(By.xpath("//button[@ng-class='btnClass2']")).click(); //changed the locator

    }
    public void addToDeposit(){

        WebElement e =findElementWithWait(By.xpath("//input[@type='number']"));

        e.sendKeys("1000");
        findElementWithWait(By.xpath("//button[@type='submit']")).click(); // here you have typed 3 slashes

        WebElement ee =findElementWithWait(By.xpath("//input[@type='number']"));
        ee.sendKeys("1000");
        findElementWithWait(By.xpath("//button[@type='submit']")).click();

        //here there are two strong elements, the second is our balance value, so we take its text
        List<WebElement> strongs = findElementsWithWait(By.xpath("//strong[@class='ng-binding']"));
        String twoThousand= strongs.get(1).getText();
        Assertions.assertEquals("2000", twoThousand);
    }
}