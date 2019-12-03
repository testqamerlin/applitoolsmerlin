package com.applitoolsqamerlin.homePage;

import com.applitoolsqamerlin.utitilities.GeneralUtilities;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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
  private By tableRowHomeLocator2;
  private By amountHomeLocator;
  private By descriptionHomeLocator;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 60);

    tableRowHomeLocator = By.xpath("//*[@id=\"transactionsTable\"]/tbody");
    tableRowHomeLocator2 = By.xpath("//*[@id=\"transactionsTable\"]/tbody/tr");
    amountHomeLocator = By.id("amount");
    descriptionHomeLocator = By.className("cell-with-media");
  }

  public List<WebElement> getBodyTableHome() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowHomeLocator));
    return driver.findElement(tableRowHomeLocator).findElements(By.className("text-right"));
  }

  public List<WebElement> getBodyTableHome2() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(tableRowHomeLocator));
    return driver.findElements(tableRowHomeLocator2);
  }

  public Integer[] returnOrderHigherToMinor22() {
    Integer[] array;
    String[] description = new String[6];
    array = returnAmountValues();
    description = returnAmountValues442();
    for (int x = 0; x < array.length; x++) {
      for (int i = 0; i < array.length - x - 1; i++) {
        if (array[i] < array[i + 1]) {
          int tmp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = tmp;
          description[i] = description[i] + "//"+ array[i];
        }
      }
    }

    System.out.println(array[0]);
    System.out.println(array[1]);
    System.out.println(array[2]);
    System.out.println(array[3]);
    System.out.println(array[4]);
    System.out.println(array[5]);
    System.out.println(description[0]);
    System.out.println(description[1]);
    System.out.println(description[2]);
    System.out.println(description[3]);
    System.out.println(description[4]);
    System.out.println(description[5]);
    return array;
  }

  public String[] returnAmountValues442() {
    String[] description = new String[6];
    for (int i = 0; i <= getBodyTableHome().size() - 1; i++) {
      description[i] = getBodyTableHome2().get(i).findElement(descriptionHomeLocator).getText();
    }
//    System.out.println(description[0]);
//    System.out.println(description[1]);
//    System.out.println(description[2]);
//    System.out.println(description[3]);
//    System.out.println(description[4]);
//    System.out.println(description[5]);
    return description;
  }

  public void hash()
  {
    Integer[] array;
    String[] description;
    array = returnAmountValues();
    description = returnAmountValues442();

    HashMap<Integer,String> map = new HashMap<Integer, String>();
    map.put(array[0],description[0]);
    map.put(array[1],description[1]);
    map.put(array[2],description[2]);
    map.put(array[3],description[3]);
    map.put(array[4],description[4]);
    map.put(array[5],description[5]);

    System.out.println(map);
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

  public String returnTextDescriptionHome()
  {
    return driver.findElement(tableRowHomeLocator).findElements(descriptionHomeLocator).get(0).getText();
  }

}
