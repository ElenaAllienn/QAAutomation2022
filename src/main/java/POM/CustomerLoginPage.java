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

 /*   public void SelectMenu(){
        WebDriver driver;
        WebElement testDropDown = driver.findElement(By.id("userSelect"));
        Select dropdown = new Select(testDropDown);
        dropdown.getOptions(2);
    ????????????
    }*/
    public void Btn(){
        findElementWithWait(By.xpath("//button[@type='submit']")).click();
        findElementWithWait(By.xpath("//button[@class='btn btn-lg tab btn-primary']")).click();

    }
    public void addToDeposit(){

        WebElement e =findElementWithWait(By.xpath("//input[@type='number']"));

        e.sendKeys("1000");
        findElementWithWait(By.xpath("///button[@type='submit']")).click();

        WebElement ee =findElementWithWait(By.xpath("//input[@type='number']"));
        ee.sendKeys("1000");
        findElementWithWait(By.xpath("///button[@type='submit']")).click();

        WebElement balance = findElementWithWait(By.name("Balance"));
        //Assertions.assertEquals(By.className("ng-binding"="2000"));////??????
    }
}