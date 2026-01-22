package tests;

import base.MobileBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends MobileBaseTest {

    @Test
    public void appShouldLaunch() {
        Assert.assertNotNull(driver);
    }
}
