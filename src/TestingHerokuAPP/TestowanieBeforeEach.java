package TestingHerokuAPP;

import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public class TestowanieBeforeEach {

    WebDriver driver;

    @BeforeEach
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://the-internet.herokuapp.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void driverQuit() {
        driver.close();
    }


    @Test
    public void Komunikaty() throws InterruptedException {

        WebElement NotificationMessage = driver.findElement(By.linkText("Notification Messages"));
        NotificationMessage.click();
        Thread.sleep(1000);

        WebElement ClickHere = driver.findElement(By.linkText("Click here"));
        ClickHere.click();
        Thread.sleep(1000);

        String alert = driver.findElement(By.cssSelector("div[id='flash']")).getText();

        String AlertCheck = ("Action unsuccesful, please try again\n×");

        if (alert.equals("Action successful\n×")) {
            System.out.println("Jest GIT");
        } else if (alert.equals("Action unsuccesful, please try again\n×")) {
            System.out.println("Jest ŹLE");
        } else {
            System.out.println("Fucking fuck");
        }

        int counter = 0;
        while (Objects.equals(alert, AlertCheck)) {
            driver.findElement(By.linkText("Click here")).click();
            alert = driver.findElement(By.cssSelector("div[id='flash']")).getText();
            System.out.println("Wynik unssuccesful numer: " + ++counter);
        }
        System.out.println("Wynik successful");
        Thread.sleep(2000);

    }
    @Test
    public void Checkbox() throws InterruptedException {
        WebElement checkboxes = driver.findElement(By.linkText("Checkboxes"));
        checkboxes.click();
        Thread.sleep(2000);
    }
}