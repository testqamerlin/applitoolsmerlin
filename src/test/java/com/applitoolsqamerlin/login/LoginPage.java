package com.applitoolsqamerlin.login;

import com.applitoolsqamerlin.utitilities.GeneralUtilities;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

  private GeneralUtilities generalUtilities = new GeneralUtilities();
  private String userName = "USERNAME";
  private String password = "PASSWORD";
  private String userNameTag = "USERNAMETAG";
  private String passwordTag = "PASSWORDTAG";
  private String loginTitle = "LOGINTITLE";
  private String errorMessageEmpty = "ERRORMESSAGE";
  private String errorMessageUser ="ERRORMESSAGEUSER";
  private String errorMessagePassword ="ERRORMESSAGEPASSWORD";
  private WebDriver driver;
  private WebDriverWait wait;
  private By wrapperLoginLocator ;
  private By logoLoginLocator ;
  private By authBoxLoginLocator;
  private By boxLogoLoginLocator;
  private By authBoxHeaderLoginLocator;
  private By headerTitleLoginLocator;
  private By userNameTagLoginLocator;
  private By iconLoginLocator;
  private By textBoxUserNameLoginLocator;
  private By passwordTagLoginLocator;
  private By textBoxPasswordLoginLocator;
  private By buttonLoginLocator;
  private By checkBoxRememberLoginLocator;
  private By twitterLogoLoginLocator;
  private By facebookLogoLoginLocator;
  private By linkedinLogoLoginLocator;
  private By alertEmptyLoginLocator;
  private By randomIdLoginLocator;
  private By homePageLocator;
  private By messageErrorEmptyLocator;


public LoginPage(WebDriver driver) {
  this.driver = driver;
  wait = new WebDriverWait(driver,60);

  wrapperLoginLocator  = By.className("auth-wrapper");
  logoLoginLocator = By.xpath("/html/body/div/div/div[1]/a/img");
  authBoxLoginLocator = By.className("auth-box-w");
  boxLogoLoginLocator = By.className("logo-w");
  authBoxHeaderLoginLocator= By.className("auth-header");
  headerTitleLoginLocator = By.xpath("/html/body/div/div/h4");
  userNameTagLoginLocator = By.xpath("/html/body/div/div/form/div[1]/label");
  iconLoginLocator = By.className("pre-icon");
  textBoxUserNameLoginLocator = By.id("username");
  passwordTagLoginLocator = By.xpath("/html/body/div/div/form/div[2]/label");
  textBoxPasswordLoginLocator = By.id("password");
  buttonLoginLocator =By.id("log-in");
  checkBoxRememberLoginLocator = By.className("form-check-input");
  twitterLogoLoginLocator = By.xpath("/html/body/div/div/form/div[3]/div[2]/a[1]/img");
   facebookLogoLoginLocator = By.xpath("/html/body/div/div/form/div[3]/div[2]/a[2]/img");
   linkedinLogoLoginLocator = By.xpath("/html/body/div/div/form/div[3]/div[2]/a[3]/img");
   alertEmptyLoginLocator = By.id("alertEmpty");
   randomIdLoginLocator = By.xpath("//*[contains(@id,\"random_id_\")]");
   homePageLocator = By.className("element-balances");
   messageErrorEmptyLocator = By.xpath("//*[@id=\"random_id_\"]/text()[1]");

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

  public String getConstantsLoginTitle() {
    return getConstants(loginTitle);
  }
  public String getConstantsUserNameTag() {
    return getConstants(userNameTag);
  }
  public String getConstantsPasswordTag() {
    return getConstants(passwordTag);
  }

  public String getConstantsErrorEmpty() {
    return getConstants(errorMessageEmpty);
  }

  public String getConstantsErrorUser() {
    return getConstants(errorMessageUser);
  }

  public String getConstantsErrorPassword() {
    return getConstants(errorMessagePassword);
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

  public boolean getURL()
  {
    return driver.getCurrentUrl().contains(getEnvironment("PATHHACKATON"));
  }

  public boolean isDisplayedWrapperLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(wrapperLoginLocator));
    return driver.findElement(wrapperLoginLocator).isDisplayed();
  }

  public boolean isDisplayedLogoLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(logoLoginLocator));
    return driver.findElement(logoLoginLocator).isDisplayed();
  }

  public boolean isDisplayedAuthBoxLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(authBoxLoginLocator));
    return driver.findElement(authBoxLoginLocator).isDisplayed();
  }

  public boolean isDisplayedBoxLogoLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(boxLogoLoginLocator));
    return driver.findElement(boxLogoLoginLocator).isDisplayed();
  }

  public boolean isDisplayedBoxHeaderLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(authBoxHeaderLoginLocator));
    return driver.findElement(authBoxHeaderLoginLocator).isDisplayed();
  }

  public String returnTextTitleLogin()
  {
        return getHeaderTitleLogin().getText();
  }

  public boolean returnDisplayedTitleLogin()
    {
          return getHeaderTitleLogin().isDisplayed();
    }

    public WebElement getHeaderTitleLogin()
    {
      wait.until(ExpectedConditions.visibilityOfElementLocated(headerTitleLoginLocator));
      return driver.findElement(headerTitleLoginLocator);
    }

  public String returnTextTagUserNameLogin()
  {
    return getTagUserNameLogin().getText();
  }

  public boolean returnDisplayedTagUserNameLogin()
  {
    return getTagUserNameLogin().isDisplayed();
  }

  public WebElement getTagUserNameLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(userNameTagLoginLocator));
    return driver.findElement(userNameTagLoginLocator);
  }


  public boolean getIconLoginLocator(int getPosition)
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(iconLoginLocator));
    return driver.findElements(iconLoginLocator).get(getPosition).isDisplayed();
  }

  public boolean returnDisplayedUserNameIconLogin(){
  return getIconLoginLocator(0);
  }

  public boolean returnDisplayedPasswordIconLogin(){
    return getIconLoginLocator(1);
  }

   public  WebElement getUserNameTextBoxLogin(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxUserNameLoginLocator));
    return driver.findElement(textBoxUserNameLoginLocator);
   }

   public void sendUserName()
   {
     getUserNameTextBoxLogin().sendKeys(randomCredentialsLogin());
   }

  public void sendPassword()
  {
    getPasswordTextBoxLogin().sendKeys(randomCredentialsLogin() + "**");
  }

   public boolean returnDisplayedUserNameTextBoxLogin()
   {
     return getUserNameTextBoxLogin().isDisplayed();
   }


  public String returnTextTagPasswordLogin()
  {
    return getTagPasswordLogin().getText();
  }

  public boolean returnDisplayedTagPasswordLogin()
  {
    return getTagPasswordLogin().isDisplayed();
  }

  public WebElement getTagPasswordLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTagLoginLocator));
    return driver.findElement(passwordTagLoginLocator);
  }

  public  WebElement getPasswordTextBoxLogin(){
    wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxPasswordLoginLocator));
    return driver.findElement(textBoxPasswordLoginLocator);
  }

  public boolean returnDisplayedPasswordTextBoxLogin()
  {
    return getUserNameTextBoxLogin().isDisplayed();
  }

  public WebElement getButtonLogin(){

    wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLoginLocator));
    return driver.findElement(buttonLoginLocator);
  }
  public boolean returnDisplayedButtonLogin(){
    return getButtonLogin().isDisplayed();
  }

  public boolean returnEnableButtonLogin(){
    return getButtonLogin().isEnabled();
  }

  public WebElement getCheckBoxRememberLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxRememberLoginLocator));
    return driver.findElement(checkBoxRememberLoginLocator);
  }

  public boolean returnDisplayedCheckBoxRememberLogin()
  {
    return getCheckBoxRememberLogin().isDisplayed();
  }

  public boolean returnEnableCheckBoxRememberLogin()
  {
    return getCheckBoxRememberLogin().isEnabled();
  }

  public boolean returnDisplayedTwitterLogoLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(twitterLogoLoginLocator));
    return driver.findElement(twitterLogoLoginLocator).isDisplayed();
  }

  public boolean returnDisplayedFacebookLogoLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(facebookLogoLoginLocator));
    return driver.findElement(facebookLogoLoginLocator).isDisplayed();
  }

  public boolean returnDisplayedLinkedinLogoLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(linkedinLogoLoginLocator));
    return driver.findElement(linkedinLogoLoginLocator).isDisplayed();
  }

  public boolean returnDisplayedAlertEmptyLogin()
  {
    wait.until(ExpectedConditions.visibilityOfElementLocated(alertEmptyLoginLocator));
    return driver.findElement(alertEmptyLoginLocator).isDisplayed();
  }

   public WebElement getRandomIdLogin()
   {
     wait.until(ExpectedConditions.presenceOfElementLocated(randomIdLoginLocator));
     return driver.findElement(randomIdLoginLocator);
   }

   public boolean returnDisplayedRandomIdLogin()
   {
     return getRandomIdLogin().isDisplayed();
   }

  private String randomCredentialsLogin() {
    String randomLogin = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder stringBuilder = new StringBuilder();
    Random rnd = new Random();
    while (stringBuilder.length() < 18) { // length of the random string.
      int index = (int) (rnd.nextFloat() * randomLogin.length());
      stringBuilder.append(randomLogin.charAt(index));
    }
    return stringBuilder.toString();
  }

  public void clickButtonLogin(){

  getButtonLogin().click();
  }

  public boolean homePageDisplayed(){
  wait.until(ExpectedConditions.visibilityOfElementLocated(homePageLocator));
  return driver.findElement(homePageLocator).isDisplayed();
  }

  public String returnTextErrorLogin()
  {
    return getRandomIdLogin().getText();
  }

  public void getScrennshot(String archiveName) {


    generalUtilities.takeSnapShot(driver,archiveName ) ;

  }






}

