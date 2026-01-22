package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public class MobileBaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        // SAMPLE capabilities for Android emulator (edit for your device/app later)
        BaseOptions options = new BaseOptions()
                .amend("platformName", "Android")
                .amend("automationName", "UiAutomator2")
                .amend("deviceName", "Android Emulator")
                .amend("appPackage", "io.appium.android.apis")
                .amend("appActivity", ".ApiDemos");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
