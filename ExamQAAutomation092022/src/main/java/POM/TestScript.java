package POM;

import org.junit.jupiter.api.*;

public class TestScript extends BaseTestClass{

    @Test
    public void Test1 (){
        CustomerLoginPage page = new CustomerLoginPage(driver, wait);
        page.NavigateToUrl();
        page.Login();
        page.SelectMenu();
        page.Btn();
        page.addToDeposit();
       



    }

}
