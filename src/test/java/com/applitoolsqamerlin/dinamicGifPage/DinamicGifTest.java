package com.applitoolsqamerlin.dinamicGifPage;

import com.applitoolsqamerlin.login.LoginPage;
import com.applitoolsqamerlin.utitilities.BaseConfigSelenium;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DinamicGifTest extends BaseConfigSelenium {

  private DinamicGifPage dinamicGifPage;
  private LoginPage loginPage;
  private SoftAssertions softAssertions;

  @Test
  public void checkDinamicGifExist() {

    softAssertions.assertThat(dinamicGifPage.dinamicGifFlashSale2Exist()).isTrue();
    softAssertions.assertThat(dinamicGifPage.dinamicGifFlashSaleExist()).isTrue();

    softAssertions.assertAll();
  }


  @BeforeEach
  public void arrangeTest() {
    loginPage = new LoginPage(driver);
    dinamicGifPage = new DinamicGifPage(driver);
    softAssertions = new SoftAssertions();
    navigateTo(dinamicGifPage.dinamicGifPage());
    loginPage.sendUserName();
    loginPage.sendPassword();
    loginPage.clickButtonLogin();
  }
}

