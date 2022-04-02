package TestObjects;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class SampleTestObjects {
    static WebDriver initialDriver;
    static SelfHealingDriver driver;

    public void openBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\VenD\\Desktop\\chromedriver.exe");
        initialDriver = new ChromeDriver();
        driver = SelfHealingDriver.create(initialDriver);
        driver.get("file:///C:/Users/VenD/Desktop/Sample.html");
        Thread.sleep(5000);
    }

    public void getTextFromPage()
    {
        System.out.println(driver.findElement(By.xpath("//div[@class='First Class']/h1[@id ='hea']")).getText());

    }

    public  void closeDriver()
    {
        SessionId s = ((RemoteWebDriver) initialDriver).getSessionId();
        System.out.println(s);
        driver.close();
    }

}
