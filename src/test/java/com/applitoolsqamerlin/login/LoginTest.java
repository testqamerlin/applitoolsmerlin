package com.applitoolsqamerlin.login;

import com.applitoolsqamerlin.utitilities.BaseConfigSelenium;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseConfigSelenium {
  private LoginPage loginPage;
  private SoftAssertions softAssertions;
  @Test
  public void loginDisplayed() {

    softAssertions.assertThat(loginPage.getIconLoginLocator(0)).isTrue();
    softAssertions.assertThat(loginPage.getIconLoginLocator(1)).isTrue();
    softAssertions.assertThat(loginPage.isDisplayedAuthBoxLogin()).isTrue();
    softAssertions.assertThat(loginPage.isDisplayedBoxHeaderLogin()).isTrue();
    softAssertions.assertThat(loginPage.isDisplayedBoxLogoLogin()).isTrue();
    softAssertions.assertThat(loginPage.isDisplayedLogoLogin()).isTrue();
    softAssertions.assertThat(loginPage.isDisplayedWrapperLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedAlertEmptyLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedButtonLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedCheckBoxRememberLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedFacebookLogoLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedLinkedinLogoLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedPasswordIconLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedPasswordTextBoxLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedRandomIdLogin()).isFalse();
    softAssertions.assertThat(loginPage.returnDisplayedTagPasswordLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedTagUserNameLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedTitleLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedTwitterLogoLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedUserNameIconLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnDisplayedUserNameTextBoxLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnEnableButtonLogin()).isTrue();
    softAssertions.assertThat(loginPage.returnEnableCheckBoxRememberLogin()).isTrue();
    softAssertions.assertThat(loginPage.getURL()).isTrue();
    softAssertions.assertThat(loginPage.returnTextTagPasswordLogin()).isEqualTo(loginPage.getConstantsPasswordTag());
    softAssertions.assertThat(loginPage.returnTextTagUserNameLogin()).isEqualTo(loginPage.getConstantsUserNameTag());
    softAssertions.assertThat(loginPage.returnTextTitleLogin()).isEqualTo(loginPage.getConstantsLoginTitle());


    softAssertions.assertAll();
    loginPage.getScrennshot("loginDisplayed");
  }

  @Test
  public void loginSuccess()
  {
    loginPage.sendUserName();
    loginPage.sendPassword();
    loginPage.clickButtonLogin();
    softAssertions.assertThat(loginPage.homePageDisplayed()).isTrue();
    softAssertions.assertAll();
    loginPage.getScrennshot("loginSuccess");

  }

  @Test
  public void loginEmpty()
  {
    loginPage.clickButtonLogin();
    softAssertions.assertThat(loginPage.returnTextErrorLogin()).isEqualTo(loginPage.getConstantsErrorEmpty());
    softAssertions.assertAll();
    loginPage.getScrennshot("loginEmpty");
  }

  @Test
  public void loginErrorUser()
  {
    loginPage.sendPassword();
    loginPage.clickButtonLogin();
    softAssertions.assertThat(loginPage.returnTextErrorLogin()).isEqualTo(loginPage.getConstantsErrorUser());
    softAssertions.assertAll();
    loginPage.getScrennshot("loginErrorUser");

  }

  @Test
  public void loginErrorPassword()
  {
    loginPage.sendUserName();
    loginPage.clickButtonLogin();
    softAssertions.assertThat(loginPage.returnTextErrorLogin()).isEqualTo(loginPage.getConstantsErrorPassword());
    softAssertions.assertAll();
    loginPage.getScrennshot("loginErrorPassword");
  }

  @BeforeEach
  public void arrangeTest()
  {
    loginPage = new LoginPage(driver);
    softAssertions = new SoftAssertions();


    navigateTo(loginPage.getPathHackaton());
  }

}
