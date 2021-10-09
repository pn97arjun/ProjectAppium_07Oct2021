import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CalcRedmiTest {
    static AppiumDriver<MobileElement> driver;
    public static void main(String[] args) {
        try {
            openCalculatorRedmi();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void openCalculatorRedmi() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi 6A");
        cap.setCapability("udid","742e68b47d27");
        cap.setCapability("platformName","Android");
        cap.setCapability("platformVersion","8.1.0 O11019");

        cap.setCapability("appPackage","com.miui.calculator");
        cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");



        URL url=new URL("http://127.0.0.1:4723/wd/hub");

        driver=new AppiumDriver<MobileElement>(url,cap);

        System.out.println("Application started");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        MobileElement agreeButton=driver.findElement(By.id("android:id/button1"));
        agreeButton.click();

        MobileElement two=driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));

        MobileElement plus=driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));

        MobileElement three=driver.findElement(By.id("com.miui.calculator:id/btn_3_s"));

        MobileElement equal=driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));



        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        two.click();
        plus.click();
        three.click();
        equal.click();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
        MobileElement result=driver.findElement(By.id("com.miui.calculator:id/result"));
        String res=result.getText();
        String trimRes=res.trim();
        String finalRes=trimRes.substring(2,3);
        System.out.println("Result: "+finalRes);

        ((AppiumDriver)driver).closeApp();
        System.out.println("QUIT");

    }
}
