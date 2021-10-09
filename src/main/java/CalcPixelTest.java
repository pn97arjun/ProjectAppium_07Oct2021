import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
//Google Pixel 4A
public class CalcPixelTest {
   static AppiumDriver<MobileElement> driver;
    public static void main(String[] args) {
        try {
            openCalculator();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void openCalculator() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","Pixel 4a");
        cap.setCapability("udid","14091JEC201625");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","11");

        cap.setCapability("appPackage","com.google.android.calculator");
        cap.setCapability("appActivity","com.android.calculator2.Calculator");

        URL url=new URL("http://127.0.0.1:4723/wd/hub");

        driver=new AppiumDriver<MobileElement>(url,cap);

        System.out.println("Application started");

        MobileElement two=driver.findElement(By.id("com.google.android.calculator:id/digit_2"));

        MobileElement plus=driver.findElement(By.id("com.google.android.calculator:id/op_add"));

        MobileElement three=driver.findElement(By.id("com.google.android.calculator:id/digit_3"));

        MobileElement equal=driver.findElement(By.id("com.google.android.calculator:id/eq"));



        Thread.sleep(5000);
        two.click();
        plus.click();
        three.click();
        equal.click();
        Thread.sleep(5000);
        MobileElement result=driver.findElement(By.className("android.widget.TextView"));
        String res=result.getText();

        System.out.println("Result: "+res);

        ((AppiumDriver)driver).closeApp();
        System.out.println("QUIT");

    }
}
