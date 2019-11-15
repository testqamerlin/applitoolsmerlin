package com.applitoolsqamerlin.com.applitoolsqamerlin.login;

import com.applitoolsqamerlin.com.applitoolsqamerlin.utitilities.GeneralUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  private GeneralUtilities generalUtilities = new GeneralUtilities();
  private String userName = "USERNAME";
  private String password = "PASSWORD";
  private WebDriver driver;
  private WebDriverWait wait;

public LoginPage(WebDriver driver) {
  this.driver = driver;
  wait = new WebDriverWait(driver,60);

  }

  public String getConstants(String constants) {
    generalUtilities.getProperties();
    return generalUtilities.loadConstants.getProperty(constants);
  }


  public String getEnvironment(String environment) {
    generalUtilities.getProperties();
    return generalUtilities.loadEnvironment.getProperty(environment);
  }

  public String getConstantsUserName() {
    return getConstants(userName);
  }

  public String getConstantsPassword() {
    return getConstants(password);
  }

  public String getBaseURL() {
    return getEnvironment("BASEURL");
  }

  public String getPathHackaton() {
    return getBaseURL()+getEnvironment("PATHHACKATON");
  }

  public String getPathIndex() {
    return getBaseURL()+getEnvironment("PATHINDEX");
  }

  public void waitTime(int time)
  {
    generalUtilities.waitTime(time);
  }


}

