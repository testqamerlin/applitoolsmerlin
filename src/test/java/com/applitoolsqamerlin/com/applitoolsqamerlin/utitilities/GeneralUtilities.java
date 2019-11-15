package com.applitoolsqamerlin.com.applitoolsqamerlin.utitilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GeneralUtilities {

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

}
