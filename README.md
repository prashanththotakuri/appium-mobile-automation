# Appium Mobile Automation Framework

<div align="center">

[![Build Status](https://img.shields.io/github/actions/workflow/status/prashanththotakuri/appium-mobile-automation/build.yml?style=flat-square)](https://github.com/prashanththotakuri/appium-mobile-automation/actions)
[![Java Version](https://img.shields.io/badge/Java-17-blue?style=flat-square)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-2.x-16A34A?style=flat-square)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.x-orange?style=flat-square)](https://testng.org/)
[![License](https://img.shields.io/badge/License-MIT-green?style=flat-square)](LICENSE)

**Enterprise-grade mobile automation** for Android and iOS apps with Appium, Java, and TestNG

[Features](#-key-features) • [Setup](#-installation) • [Examples](#-usage-examples) • [Best Practices](#-mobile-testing-best-practices) • [FAQ](#-troubleshooting)

</div>

-----

## 📋 Overview

A production-ready Appium automation framework for testing native, hybrid, and web apps on Android and iOS:

- **Multi-Platform** - Single codebase for Android and iOS testing
- **Native & Hybrid Apps** - Support for native, hybrid, and web app testing
- **Real & Emulated Devices** - Works with real devices, emulators, and simulators
- **Cloud Testing** - Integration with BrowserStack, SauceLabs, TestProject
- **Cross-Version Testing** - Test across multiple OS and app versions
- **Touch Gestures** - Swipe, tap, long press, multi-touch support
- **Permission Handling** - Manage app permissions and system dialogs
- **Performance Testing** - App performance metrics and device stats
- **CI/CD Ready** - GitHub Actions, Jenkins, GitLab CI integration
- **Detailed Reports** - Extent reports with device screenshots and logs

-----

## 🎯 Key Features

|Feature                |Details                                           |
|-----------------------|--------------------------------------------------|
|**Multi-Platform**     |Android and iOS testing from one framework        |
|**App Types**          |Native, Hybrid, and Web apps                      |
|**Device Types**       |Real devices, emulators, simulators, cloud devices|
|**Touch Gestures**     |Tap, swipe, long press, multi-touch, pinch        |
|**App Management**     |Install, uninstall, background app, permissions   |
|**System Dialogs**     |Handle notifications, alerts, permission dialogs  |
|**Performance**        |FPS, battery usage, memory, network monitoring    |
|**Device Access**      |SMS, calls, device orientation, network speed     |
|**Element Interaction**|Multiple locator strategies, custom waits         |
|**Screenshot/Video**   |Automatic capture on failure                      |
|**Data-Driven**        |Parameterized tests with CSV, JSON data           |
|**CI/CD Integration**  |GitHub Actions, Jenkins, cloud providers          |

-----

## 🏗 Framework Architecture

```
appium-mobile-automation/
│
├── .github/
│   └── workflows/
│       └── build.yml                  # GitHub Actions CI/CD
│
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   ├── AppiumServer.java      # Appium server management
│   │   │   ├── DriverManager.java     # Driver lifecycle management
│   │   │   ├── TestBase.java          # Base test class
│   │   │   └── DriverFactory.java     # Android/iOS driver creation
│   │   │
│   │   ├── pages/
│   │   │   ├── BasePage.java
│   │   │   ├── android/
│   │   │   │   ├── LoginPageAndroid.java
│   │   │   │   ├── HomePageAndroid.java
│   │   │   │   └── ...
│   │   │   └── ios/
│   │   │       ├── LoginPageIOS.java
│   │   │       ├── HomePageIOS.java
│   │   │       └── ...
│   │   │
│   │   ├── utils/
│   │   │   ├── AppiumUtil.java        # Appium utilities
│   │   │   ├── GestureUtil.java       # Gestures (swipe, tap, etc.)
│   │   │   ├── PermissionUtil.java    # Permission handling
│   │   │   ├── DeviceUtil.java        # Device info & settings
│   │   │   ├── ConfigReader.java      # Configuration
│   │   │   ├── WaitUtil.java          # Waits
│   │   │   └── ReportUtil.java        # Reporting
│   │   │
│   │   ├── enums/
│   │   │   ├── Platform.java          # ANDROID, IOS
│   │   │   └── DeviceType.java        # REAL, EMULATOR, CLOUD
│   │   │
│   │   └── models/
│   │       ├── User.java
│   │       └── TestData.java
│   │
│   └── test/java/
│       └── tests/
│           ├── LoginTests.java        # Cross-platform tests
│           ├── DashboardTests.java
│           └── ...
│
├── src/test/resources/
│   ├── config.properties              # Configuration
│   ├── android/
│   │   ├── android-config.properties
│   │   └── test-app.apk
│   ├── ios/
│   │   ├── ios-config.properties
│   │   └── test-app.ipa
│   └── testdata.json
│
├── pom.xml
└── README.md
```

-----

## 🚀 Installation

### Prerequisites

- **Java 17+** ([Download](https://www.oracle.com/java/technologies/downloads/))
- **Maven 3.8+** ([Download](https://maven.apache.org/download.cgi))
- **Appium 2.x** ([Install](https://appium.io/docs/en/2.0/quickstart/install/))
- **Android SDK** (for Android testing)
- **Xcode** (for iOS testing on macOS)

### Setup for Android

1. **Install Android SDK**
   
   ```bash
   # Set environment variables
   export ANDROID_HOME=/path/to/android-sdk
   export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
   ```
1. **Create Android Emulator**
   
   ```bash
   android create avd -n test_emulator -t android-33
   emulator -avd test_emulator
   ```
1. **Verify Setup**
   
   ```bash
   adb devices
   ```

### Setup for iOS

1. **Install Xcode**
   
   ```bash
   xcode-select --install
   ```
1. **Install iOS Simulator**
   
   ```bash
   xcrun instruments -s devices
   ```
1. **Verify Setup**
   
   ```bash
   which appium
   appium --version
   ```

### Setup Framework

1. **Clone repository**
   
   ```bash
   git clone https://github.com/prashanththotakuri/appium-mobile-automation.git
   cd appium-mobile-automation
   ```
1. **Install dependencies**
   
   ```bash
   mvn clean install
   ```
1. **Configure capabilities**
   
   ```properties
   # src/test/resources/android-config.properties
   platform=ANDROID
   platformVersion=13.0
   deviceName=emulator-5554
   app=/path/to/app.apk
   automationName=UiAutomator2
   ```
1. **Start Appium Server**
   
   ```bash
   appium --port 4723
   ```
1. **Run tests**
   
   ```bash
   mvn test
   ```

-----

## 📊 Performance & Scale

|Metric                  |Value        |Details             |
|------------------------|-------------|--------------------|
|**Android Test Cases**  |40+          |Various app flows   |
|**iOS Test Cases**      |40+          |Same flows, iOS     |
|**Devices Tested**      |8+           |Real + emulated     |
|**Sequential Runtime**  |~8-10 minutes|Single device       |
|**Parallel (2 devices)**|~5-6 minutes |40% faster          |
|**Flakiness**           |<2%          |Through proper waits|
|**App Performance**     |<3s startup  |Average load time   |

-----

## 💡 Usage Examples

### Example 1: Android Login Test

```java
package tests;

import org.testng.annotations.Test;
import base.TestBase;
import pages.android.LoginPageAndroid;
import pages.android.HomePageAndroid;

public class AndroidLoginTests extends TestBase {
    
    @Test
    public void testValidLogin() {
        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        HomePageAndroid homePage = new HomePageAndroid(driver);
        
        // Wait for app to load
        loginPage.waitForLoginPageToLoad();
        
        // Enter credentials
        loginPage.enterEmail("user@example.com");
        loginPage.enterPassword("password123");
        
        // Tap login button
        loginPage.clickLoginButton();
        
        // Verify successful login
        assert homePage.isDashboardDisplayed() : "Dashboard not shown";
        assert homePage.getUserGreeting().contains("John") : "Greeting not displayed";
    }
}
```

### Example 2: Cross-Platform Test (Single Code, Multiple Devices)

```java
public class LoginTests extends TestBase {
    
    @Test
    public void testLoginFlow() {
        // Page initialization handles Android/iOS differences
        LoginPage loginPage = new LoginPageFactory(driver, platform).createLoginPage();
        HomePage homePage = new HomePageFactory(driver, platform).createHomePage();
        
        // Same test code for both platforms
        loginPage.navigateToLogin();
        loginPage.login("user@example.com", "password123");
        
        assert homePage.isDashboardDisplayed();
    }
}

// Factory handles platform-specific page objects
public class LoginPageFactory {
    public LoginPage createLoginPage() {
        if (platform == Platform.ANDROID) {
            return new LoginPageAndroid(driver);
        } else {
            return new LoginPageIOS(driver);
        }
    }
}
```

### Example 3: Touch Gestures

```java
public class ProductTests extends TestBase {
    
    @Test
    public void testSwipeProduct() {
        ProductPage productPage = new ProductPage(driver);
        
        // Swipe left
        GestureUtil.swipeLeft(driver, productPage.getProductImage());
        
        // Verify next product shown
        assert productPage.getProductName().equals("Product 2");
        
        // Long press to add to wishlist
        GestureUtil.longPress(driver, productPage.getAddToWishlistButton());
        
        // Pinch to zoom
        GestureUtil.pinch(driver, productPage.getProductImage(), 0.5);
    }
    
    @Test
    public void testMultiTouchGesture() {
        GestureUtil.multiTap(driver, element, 3); // Triple tap
        GestureUtil.twoFingerTap(driver, element);
    }
}
```

### Example 4: Permissions & System Dialogs

```java
@Test
public void testLocationPermission() {
    PermissionUtil.grantPermission(driver, "android.permission.ACCESS_FINE_LOCATION");
    
    // Interact with app that needs location
    mapPage.openMap();
    
    // Verify location used
    assert mapPage.isMapDisplayed();
}

@Test
public void testNotificationAlert() {
    // Handle notification
    driver.executeScript("mobile:notification", new HashMap<String, Object>() {{
        put("intent", "com.example.app.PUSH_NOTIFICATION");
    }});
    
    // Verify notification handled
    assert notificationPage.isNotificationProcessed();
}

@Test
public void testSystemAlert() {
    // Click Allow on system alert
    driver.switchTo().alert().accept();
    
    // Or dismiss
    driver.switchTo().alert().dismiss();
}
```

### Example 5: Performance Monitoring

```java
@Test
public void testAppPerformance() {
    DeviceUtil deviceInfo = new DeviceUtil(driver);
    
    // Get initial metrics
    long initialMemory = deviceInfo.getAppMemoryUsage();
    int initialBattery = deviceInfo.getBatteryLevel();
    
    // Perform action
    app.performHeavyOperation();
    
    // Get metrics after action
    long finalMemory = deviceInfo.getAppMemoryUsage();
    int finalBattery = deviceInfo.getBatteryLevel();
    
    // Verify memory didn't leak
    assert (finalMemory - initialMemory) < 50_000_000 : "Memory leaked";
    
    // Verify battery usage reasonable
    assert (initialBattery - finalBattery) < 5 : "Excessive battery drain";
}

@Test
public void testAppStartupTime() {
    long startTime = System.currentTimeMillis();
    
    // Force kill and restart app
    AppiumUtil.stopApp(driver, "com.example.app");
    AppiumUtil.startApp(driver, "com.example.app");
    
    long startupTime = System.currentTimeMillis() - startTime;
    
    assert startupTime < 5000 : "App startup > 5 seconds";
}
```

### Example 6: Data-Driven Mobile Tests

```java
@Test(dataProvider = "loginCredentials")
public void testLoginMultipleUsers(String email, String password, boolean shouldSucceed) {
    LoginPage loginPage = new LoginPageFactory(driver, platform).createLoginPage();
    
    loginPage.login(email, password);
    
    if (shouldSucceed) {
        assert new HomePageFactory(driver, platform).createHomePage().isDashboardDisplayed();
    } else {
        assert loginPage.isErrorMessageDisplayed();
    }
}

@DataProvider
public Object[][] loginCredentials() {
    return new Object[][] {
        {"valid@email.com", "password123", true},
        {"invalid@email.com", "wrongpass", false},
        {"", "", false}
    };
}
```

-----

## 🔧 Desired Capabilities

### Android Capabilities

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("platformVersion", "13.0");
capabilities.setCapability("deviceName", "emulator-5554");
capabilities.setCapability("app", "/path/to/app.apk");
capabilities.setCapability("automationName", "UiAutomator2");
capabilities.setCapability("autoGrantPermissions", true);
capabilities.setCapability("noReset", false);
capabilities.setCapability("fullReset", false);
```

### iOS Capabilities

```java
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability("platformName", "iOS");
capabilities.setCapability("platformVersion", "16.0");
capabilities.setCapability("deviceName", "iPhone 14");
capabilities.setCapability("app", "/path/to/app.ipa");
capabilities.setCapability("automationName", "XCUITest");
capabilities.setCapability("bundleId", "com.example.app");
capabilities.setCapability("xcodeOrgId", "your-team-id");
```

-----

## 📱 Mobile Testing Best Practices

### 1. **Use Flexible Locators**

```java
// ✅ GOOD - More stable
By loginButton = MobileBy.AccessibilityId("login_button");
By input = By.id("com.example:id/email_input");

// ❌ BAD - Brittle XPath
By element = By.xpath("//android.widget.Button[2]");
```

### 2. **Handle Waits Properly**

```java
// ✅ GOOD - Explicit wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.presenceOfElementLocated(locator));

// ❌ BAD - Thread sleep
Thread.sleep(5000);
```

### 3. **Manage App State**

```java
// ✅ GOOD - Known state for each test
@BeforeMethod
public void setupTest() {
    AppiumUtil.stopApp(driver, APP_ID);
    AppiumUtil.startApp(driver, APP_ID);
}

// ❌ BAD - Relying on previous test state
```

### 4. **Handle Network Changes**

```java
// ✅ GOOD - Test offline scenarios
driver.executeScript("mobile:toggleAirplaneMode");
testOfflineFunctionality();

// ❌ BAD - Ignoring network issues
```

-----

## ☁️ Cloud Testing Integration

### BrowserStack

```properties
# config.properties
browserstack.local=false
browserstack.debug=true
browserstack.device=iPhone 12
browserstack.os=iOS
browserstack.os_version=15
```

### SauceLabs

```java
MutableCapabilities saucelabs = new MutableCapabilities();
saucelabs.setCapability("sauce:options", new HashMap<String, Object>() {{
    put("username", sauceUsername);
    put("accessKey", sauceKey);
}});
```

-----

## ❓ Troubleshooting

### Q: Element not found error

**A:** Use flexible waits and locators:

```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.presenceOfElementLocated(locator));
```

### Q: Flaky tests on real devices

**A:** Add buffer time and retry logic:

```java
@Test(retryAnalyzer = RetryAnalyzer.class)
public void testFeature() { ... }
```

### Q: How do I test on real device?

**A:** Use device farm or local device with ADB:

```bash
adb connect 192.168.1.100:5555
adb devices
```

-----

## 📚 Resources

- [Appium Documentation](https://appium.io/docs/en/latest/)
- [Mobile Best Practices](https://appium.io/docs/en/latest/guides/)
- [UiAutomator2 Documentation](https://developer.android.com/training/testing/ui-automator)
- [XCUITest Documentation](https://developer.apple.com/xcode/testing/)

-----

## 🤝 Contributing

Contributions welcome!

-----

## 📝 License

MIT License

-----

## 👤 Author

**Prashanth Thotakuri**  
Senior QA Automation Engineer  
[GitHub](https://github.com/prashanththotakuri) • [LinkedIn](https://www.linkedin.com/in/prashanth-prashanth-57b691130)

-----

<div align="center">

**⭐ Star the repo if this helps!**

[⬆ Back to Top](#appium-mobile-automation-framework)

</div>