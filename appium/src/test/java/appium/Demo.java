package appium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Demo {

    AndroidDriver driver;

    @BeforeMethod
	@BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("automationName" , "UiAutomator2");
        caps.setCapability("platformName" , "Android");
        //caps.setCapability("platformVersion" , "9.0");
        caps.setCapability("deviceName" , "Android");
        caps.setCapability("app" , System.getProperty("user.dir")+"/selendroid-test-app-0.17.0.apk");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void test_Appium() throws MalformedURLException, InterruptedException {
        String message = "Hello GitHub Actions";
        WebElement messageTxt = driver.findElement(By.id("my_text_field"));
        messageTxt.sendKeys(message);
        System.out.println(messageTxt.getText());
        Assert.assertEquals(message,messageTxt.getText());
    }

    @AfterMethod
	@AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}