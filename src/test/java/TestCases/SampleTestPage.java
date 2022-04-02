package TestCases;
import TestObjects.SampleTestObjects;
import org.testng.annotations.Test;

public class SampleTestPage extends SampleTestObjects {
  @Test
    public void openTheApp() throws InterruptedException {
        openBrowser();
        getTextFromPage();
        closeDriver();
    }



}
