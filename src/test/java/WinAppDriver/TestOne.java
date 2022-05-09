package WinAppDriver;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestOne {
    public static WindowsDriver driver = null;
    public static WebElement CalculatorResult;
    @BeforeTest
        public static void setup () throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            caps.setCapability("platformName", "Windows");
            caps.setCapability("platformVersion", "1.0");
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
            System.out.println(driver.getSessionId());
        CalculatorResult = driver.findElementByAccessibilityId("CalculatorResults");
        Assert.assertNotNull(CalculatorResult);
        }
        @Test (priority = 0)

        public void Add_Test () {
            driver.findElementByName("Two").click();
            driver.findElementByName("Plus").click();
            driver.findElementByName("Five").click();
            driver.findElementByName("Equals").click();
            Assert.assertEquals("7",_GetCalculatorResultText());

        }
        @Test (priority = 1)
        public void Sub_Test(){
            driver.findElementByName("Seven").click();
            driver.findElementByName("Minus").click();
            driver.findElementByName("Four").click();
            driver.findElementByName("Equals").click();
            Assert.assertEquals("3",_GetCalculatorResultText());
        }
        @Test (priority = 2)
       public void Mul_Test(){
            driver.findElementByName("Nine").click();
            driver.findElementByName("Multiply by").click();
            driver.findElementByName("Eight").click();
            driver.findElementByName("Equals").click();
            Assert.assertEquals("72",_GetCalculatorResultText());
        }
        @Test (priority = 3)
    public void Div_Test(){
            driver.findElementByName("Eight").click();
            driver.findElementByName("Divide by").click();
            driver.findElementByName("Two").click();
            driver.findElementByName("Equals").click();
            Assert.assertEquals("4",_GetCalculatorResultText());
        }
        @AfterTest
    public void tear_Down()
        {
            driver.quit();
        }
    protected String _GetCalculatorResultText()
    {
        // trim extra text and whitespace off of the display value
        return CalculatorResult.getText().replace("Display is", "").trim();
    }

    }


