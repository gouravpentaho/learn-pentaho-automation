/*!
 * HITACHI VANTARA PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2019 Hitachi Vantara. All rights reserved.
 *
 * NOTICE: All information including source code contained herein is, and
 * remains the sole property of Hitachi Vantara and its licensors. The intellectual
 * and technical concepts contained herein are proprietary and confidential
 * to, and are trade secrets of Hitachi Vantara and may be covered by U.S. and foreign
 * patents, or patents in process, and are protected by trade secret and
 * copyright laws. The receipt or possession of this source code and/or related
 * information does not convey or imply any rights to reproduce, disclose or
 * distribute its contents, or to manufacture, use, or sell anything that it
 * may describe, in whole or in part. Any reproduction, modification, distribution,
 * or public display of this information without the express written authorization
 * from Hitachi Vantara is strictly prohibited and in violation of applicable laws and
 * international treaties. Access to the source code contained herein is strictly
 * prohibited to anyone except those individuals and entities who have executed
 * confidentiality and non-disclosure agreements or other agreements with Hitachi Vantara,
 * explicitly covering such access.
 */

package pages.puc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the Pentaho User Console Login Page. It is one of the few pages without a PUC ToolBar
 */
public class LoginPage {

  WebDriver driver;

  HomePage homePage = new HomePage(driver);

  @FindBy( id = "login-header-logo" )
  private WebElement hitachiLogo;

  @FindBy( id = "j_username" )
  private WebElement usernameField;

  @FindBy( id = "j_password" )
  private WebElement passwordField;

  @FindBy( id = "loginbtn" )
  private WebElement loginButton;

  @FindBy( id = "eval-users-toggle" )
  private WebElement evaluatorLogin;

  @FindBy( xpath = "//div[@class='login-role'][contains(text(),'Administrator')]" )
  private WebElement evaluatorAdministrator;

  @FindBy( xpath = "//div[@class='span6 login-value'][contains(text(),'Admin')]" )
  private WebElement adminUsername;

  @FindBy( xpath = "//html//div[@id='role-admin-panel']/div[3]/div[2]" )
  private WebElement adminPassword;

  @FindBy( xpath = "//div[@id='role-admin-panel']//button[@class='btn']" )
  private WebElement adminGo;

  @FindBy( xpath = "//div[@class='login-role'][contains(text(),'Business User')]" )
  private WebElement evaluatorBusinessUser;

  @FindBy( xpath = "//div[@class='span6 login-value'][contains(text(),'Suzy')]" )
  private WebElement evaluatorUsername;

  @FindBy( xpath = "//html//div[@id='role-business-user-panel']/div[3]/div[2]" )
  private WebElement evaluatorPassword;

  @FindBy( xpath = "//div[@id='role-business-user-panel']//button[@class='btn']" )
  private WebElement evaluatorGo;

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
  }

  /**
   * Login action using the provided username and password
   *
   * @param username
   * @param password
   * @return HomePage
   */
  public boolean login( String username, String password ) {
    if (usernameField.isDisplayed()) {
      usernameField.sendKeys( username );
      passwordField.click();
      passwordField.sendKeys( password );
      loginButton.click();
      System.out.println("Logging to PUC");
      try{
        Thread.sleep(45000);
      } catch(InterruptedException ex) {
        System.out.println("Exception !!" + ex);
      }
    }
    return true;
  }
}