package com.applitoolsqamerlin.dinamicGifPage;

import com.applitoolsqamerlin.utitilities.GeneralUtilities;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DinamicGifPage {

  private WebDriver driver;
  private GeneralUtilities generalUtilities = new GeneralUtilities();
  private WebDriverWait wait;
  private By dinamicFlashSale2Locator;
  private By dinamicFlashSaleLocator;

  public DinamicGifPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 60);

    dinamicFlashSale2Locator = By.id("flashSale2");
    dinamicFlashSaleLocator = By.id("flashSale");
  }

  public String getEnvironment(String environment) {
    generalUtilities.getProperties();
    return generalUtilities.loadEnvironment.getProperty(environment);
  }

  public String getBaseURL() {
    return getEnvironment("BASEURL");
  }

  public String dinamicGifPage() {
    return getBaseURL()+getEnvironment("PATHDINAMICGIF");
  }

  public boolean dinamicGifFlashSale2Exist()
  {
    return generalUtilities.existElement(dinamicFlashSale2Locator,driver);
  }

  public boolean dinamicGifFlashSaleExist()
  {
    return generalUtilities.existElement(dinamicFlashSaleLocator,driver);
  }

}
