package com.applitoolsqamerlin.homePage;

import com.applitoolsqamerlin.login.LoginPage;
import com.applitoolsqamerlin.utitilities.BaseConfigSelenium;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeTest extends BaseConfigSelenium {

  private HomePage homePage;
  private LoginPage loginPage;
  private SoftAssertions softAssertions;

  @Test
  public void checkOrderMinorToHigher() {
    Integer[] arrayOrder = homePage.returnOrderMinorToHigher();
    homePage.clickAmountHome();
    Integer[] actualOrder = homePage.returnAmountValues();
    System.out.println(homePage.returnTextDescriptionHome());

    softAssertions.assertThat(arrayOrder[0]).isEqualTo(actualOrder[0]);
    softAssertions.assertThat(arrayOrder[1]).isEqualTo(actualOrder[1]);
    softAssertions.assertThat(arrayOrder[2]).isEqualTo(actualOrder[2]);
    softAssertions.assertThat(arrayOrder[3]).isEqualTo(actualOrder[3]);
    softAssertions.assertThat(arrayOrder[4]).isEqualTo(actualOrder[4]);
    softAssertions.assertThat(arrayOrder[5]).isEqualTo(actualOrder[5]);

    softAssertions.assertAll();
  }

  @Test
  public void checkOrderHigherToMinor() {
    Integer[] arrayOrder = homePage.returnOrderHigherToMinor();
    homePage.clickAmountHome();
    homePage.clickAmountHome();
    Integer[] actualOrder = homePage.returnAmountValues();

    softAssertions.assertThat(arrayOrder[0]).isEqualTo(actualOrder[0]);
    softAssertions.assertThat(arrayOrder[1]).isEqualTo(actualOrder[1]);
    softAssertions.assertThat(arrayOrder[2]).isEqualTo(actualOrder[2]);
    softAssertions.assertThat(arrayOrder[3]).isEqualTo(actualOrder[3]);
    softAssertions.assertThat(arrayOrder[4]).isEqualTo(actualOrder[4]);
    softAssertions.assertThat(arrayOrder[5]).isEqualTo(actualOrder[5]);

    softAssertions.assertAll();
  }

  @Test
  public void test()
  {
    homePage.hash();
//    homePage.returnOrderHigherToMinor22();
//    homePage.returnAmountValues442();

  }

  @BeforeEach
  public void arrangeTest() {
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    softAssertions = new SoftAssertions();
    navigateTo(loginPage.getPathHackaton());
    loginPage.sendUserName();
    loginPage.sendPassword();
    loginPage.clickButtonLogin();
  }
}

