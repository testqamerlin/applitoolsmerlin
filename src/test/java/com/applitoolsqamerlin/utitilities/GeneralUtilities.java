package com.applitoolsqamerlin.utitilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class GeneralUtilities extends BaseConfigSelenium {

  public Properties loadConstants = new Properties();
  public Properties loadEnvironment = new Properties();

  /**
   * Method that load and get properties file.
   */
  public void getProperties() {
    ClassLoader loader = getClass().getClassLoader();

    try {

      InputStream inputStreamConstants = loader.getResourceAsStream("Constants.properties");
      InputStream inputStreamEnvironment = loader.getResourceAsStream("Environment.properties");

      loadConstants.load(inputStreamConstants);
      loadEnvironment.load(inputStreamEnvironment);

    } catch (IOException exc) {
      throw new RuntimeException("Properties files not found", exc);
    }

  }

  /**
   * Method that sleep a specific time.
   */
  public static void waitTime(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void takeSnapShot(WebDriver webdriver, String archiveName) {
    try {
      //Convert web driver object to TakeScreenshot
      String systemDir = System.getProperty("user.dir");
      TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

      //Call getScreenshotAs method to create image file

      File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

      //Move image file to new destination

      File DestFile = new File(systemDir + "/testOutFile");

      //Copy file at destination
      System.out.println(SrcFile);
      System.out.println(DestFile + archiveName + ".png");
      FileUtils.copyFile(SrcFile, new File(DestFile + "/" + archiveName + ".png"));

      System.out.println(SrcFile);
    } catch (Exception exc) {
      throw new RuntimeException("Route not found", exc);
    }
  }

  /**
   * Method to check if an element is visible on the screen.
   *
   * @return boolean
   */
  public boolean existElement(By id, WebDriver webDriver) {
    driver = webDriver;
    try {
      driver.findElement(id);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

}
