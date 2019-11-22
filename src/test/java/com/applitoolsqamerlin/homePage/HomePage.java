package com.applitoolsqamerlin.homePage;

import com.applitoolsqamerlin.utitilities.GeneralUtilities;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  private WebDriver driver;
  private GeneralUtilities generalUtilities = new GeneralUtilities();
  private WebDriverWait wait;
  private By tableRowHomeLocator;
  private By amountHomeLocator;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 60);

    tableRowHomeLocator = By.xpath("//*[@id=\"transactionsTable\"]/tbody");
    amountHomeLocator = By.id("amount");
  }

  public List<WebElement> getBodyTableHome() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowHomeLocator));
    return driver.findElement(tableRowHomeLocator).findElements(By.className("text-right"));
  }

  public Integer[] returnAmountValues() {
    Integer[] array = new Integer[6];
    for (int i = 0; i <= getBodyTableHome().size() - 1; i++) {
      String str = getBodyTableHome().get(i).getText();
      String ncadena = str.substring(0, str.length() - 3);
      ncadena = ncadena.replaceAll("\\.", "");
      ncadena = ncadena.replaceAll(",", "");
      ncadena = ncadena.replaceAll("\\+", "");
      ncadena = ncadena.replaceAll(" ", "");
      array[i] = Integer.valueOf(ncadena);
    }

    return array;
  }

  public Integer[] returnOrderHigherToMinor() {
    Integer[] array;
    array = returnAmountValues();
    for (int x = 0; x < array.length; x++) {
      for (int i = 0; i < array.length - x - 1; i++) {
        if (array[i] < array[i + 1]) {
          int tmp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = tmp;
        }
      }
    }
    return array;
  }

  public Integer[] returnOrderMinorToHigher() {
    Integer[] array;
    array = returnAmountValues();
    for (int x = 0; x < array.length; x++) {
      for (int i = 0; i < array.length - x - 1; i++) {
        if (array[i] > array[i + 1]) {
          int tmp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = tmp;
        }
      }
    }
    return array;
  }

  public void clickAmountHome() {
    wait.until(ExpectedConditions.elementToBeClickable(amountHomeLocator));
    driver.findElement(amountHomeLocator).click();
  }

}
