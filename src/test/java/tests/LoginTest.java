package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Driver;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginTest extends BeforeAll_AfterAll{
  //  private WebDriver driver = Driver.getChromeDriver();


    public void getLogin() {
        driver.findElement(By.id("session_email")).sendKeys("www@www.qqq");
        driver.findElement(By.name("session[password]")).sendKeys("123QWE");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
    }

    public void getLogin(String login, String password){
        driver.findElement(By.id("session_email")).sendKeys(login);
        driver.findElement(By.name("session[password]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/login_password.csv")
    @Tag("SkipClick")
    @DisplayName("Testing of Login page")
    public void Login (String login, String password){
        getLogin(login, password);
        String title = driver.getTitle();
        Assertions.assertEquals("Address Book", title, "The incorrect page is open or invalid title is specified");
        driver.findElement(By.xpath("//a[text()='Sign out']")).click();

    }


        //Второй вариант параметризации метода Login (String login, String password)
        /* @ParameterizedTest
           @CsvSource({
              "www@www.qqq,        123QWE",
              "www@aaa.zzz,        123ppp"
         })
            @Tag("SkipClick")
            @DisplayName("Testing of Login page")
            public void Login (String login, String password){
                driver.findElement(By.id("session_email")).sendKeys(login);
                driver.findElement(By.name("session[password]")).sendKeys(password);
                driver.findElement(By.cssSelector("input[value='Sign in']")).click();
                String title = driver.getTitle();
                Assertions.assertEquals("Address Book", title, "The incorrect page is open or invalid title is specified");
                driver.findElement(By.xpath("//a[text()='Sign out']")).click();
            }*/
}
