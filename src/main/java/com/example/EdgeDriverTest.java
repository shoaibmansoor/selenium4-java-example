package com.example;

import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EdgeDriverTest {
    public static void main(String[] args) {
        System.out.println("Chromedriver path: " + System.getenv("CHROMEDRIVER_PATH"));
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\.wdm\\drivers\\edgedriver\\win64\\113.0.1774.57\\msedgedriver.exe");
//        System.setProperty("webdriver.edge.driver", System.getenv("CHROMEDRIVER_PATH"));
        String appUrl = System.getenv("APP_URL");
        String username = System.getenv("APP_USERNAME");
        String password = System.getenv("APP_PASSWORD");
        String hostname = appUrl.replace("https://", "");

        RemoteWebDriver driver = null;
        try {
            driver = new EdgeDriver();
            Predicate<URI> uriPredicate = uri -> uri.getHost().contains(hostname);

            ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(username, password));
            driver.get(appUrl);
            driver.findElement(By.xpath("//a[.='HTTP/NTLM Auth']")).click();

            Thread.sleep(5000);
            // Get Session ID
            String sessionId = driver.getSessionId().toString();
            System.out.println("Session ID: " + sessionId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
