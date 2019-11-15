package com.applitoolsqamerlin.com.applitoolsqamerlin.login;

import com.applitoolsqamerlin.com.applitoolsqamerlin.utitilities.BaseConfigSelenium;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseConfigSelenium {
  private LoginPage loginPage;
  @Test
  public void test() {

    loginPage.waitTime(5000);
  }

  @BeforeEach
  public void arrangeTest()
  {
    loginPage = new LoginPage(driver);

    navigateTo(loginPage.getPathHackaton());
  }

}
