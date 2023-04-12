package com.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    private Driver(){}
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    public static  WebDriver getDriver(){
        synchronized (Driver.class) {
            if (driverPool.get() == null) {
                String browser = Environment.getProperty("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*")));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "ie":
                        WebDriverManager.iedriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    case "firefox-headless":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                    case "remote":
                        WebDriverManager.chromedriver().setup();
                        DesiredCapabilities cap = new DesiredCapabilities();
                        cap.setCapability("browserName","chrome");
                        try {
                            driverPool.set( new RemoteWebDriver(new URL("http://34.205.16.125:4444/wd/hub"),cap));
                        }catch (MalformedURLException e){
                            e.printStackTrace();
                        }

                }
            }
            driverPool.get().manage().window().maximize();
            driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }

        return driverPool.get();
    }

    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
