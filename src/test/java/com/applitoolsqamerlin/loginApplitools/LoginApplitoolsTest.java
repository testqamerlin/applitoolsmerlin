package com.applitoolsqamerlin.loginApplitools;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitoolsqamerlin.login.LoginPage;
import com.applitoolsqamerlin.utitilities.BaseConfigSelenium;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginApplitoolsTest extends BaseConfigSelenium {

  public Eyes eyes;
  private LoginPage loginPage;

  @Test
  public void test()
  {
    eyes.setApiKey(loginPage.getConstants("APIKEY"));
    eyes.setForceFullPageScreenshot(true);
    eyes.open(driver, "Demo App", "ChartTest 2");
    eyes.checkWindow("1st Test Window");
    loginPage.sendUserName();
    loginPage.sendPassword();
    loginPage.clickButtonLogin();
    eyes.checkWindow("2st Test Window");
    eyes.closeAsync();

  }

  @BeforeEach
  public void arrange()
  {
    loginPage = new LoginPage(driver);
    eyes = new Eyes();

    navigateTo(loginPage.getPathHackaton());
  }
}
