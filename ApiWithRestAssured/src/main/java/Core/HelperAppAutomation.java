package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class HelperAppAutomation {

    DesiredCapabilities dc = new DesiredCapabilities();
    AndroidDriver driver = null;

    public AndroidDriver apkLaunch() throws MalformedURLException, InterruptedException {
        dc.setCapability(MobileCapabilityType.UDID, "c15a4201");
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "RMX2170");
        dc.setCapability("platformVersion", "12.0");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
        Thread.sleep(6000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        return driver;
    }

}
