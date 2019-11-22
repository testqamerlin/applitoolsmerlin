package com.applitoolsqamerlin.utitilities;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConfigSelenium {

  protected WebDriver driver;
  protected WebDriverWait wait;

  @BeforeEach
  public void init() {
    configCapabilities("Mac");
  }

  @AfterEach
  public void teardown() {
    driver.close();
    driver.quit();
  }

  public void navigateTo(String url) {
    driver.get(url);
  }

  public void configCapabilities(String flagOS) {
    ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//    	options.addArguments("--headless");

    if(flagOS == "Windows") {
      System.setProperty("webdriver.chrome.driver", "chromedriverWIN.exe");
      driver = new ChromeDriver(options);
    } else if(flagOS == "Mac") {
      System.setProperty("webdriver.chrome.driver", "chromedriver");
      driver = new ChromeDriver(options);
    }

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().fullscreen();
    wait = new WebDriverWait(driver, 60);
  }


}
