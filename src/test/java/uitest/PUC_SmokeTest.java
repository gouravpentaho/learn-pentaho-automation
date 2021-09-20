/*!
 * HITACHI VANTARA PROPRIETARY AND CONFIDENTIAL
 *
 * Copyright 2002 - 2018 Hitachi Vantara. All rights reserved.
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

package uitest;

import pages.puc.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * This is a sample class that demonstrates how we can login to PUC and print the Server version from help -> about.
 */
public class PUC_SmokeTest {

  WebDriver driver;

  @BeforeClass
  public void start(){

    //Setting system properties of ChromeDriver
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmudgal\\chromedriver\\chromedriver.exe");

    // Instantiate a ChromeDriver class.
    driver = new ChromeDriver();

    // Launch Website
    driver.navigate().to("http://172.20.42.232:8080/pentaho/Login");

    //Maximize the browser
    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  /**
   * This Test is executed when mvn test is performed (due to @Test TestNG annotation).
   */
  @Test
  public void loginPageTest() {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    if ( loginPage.login( "Admin", "password" ) ) {
      System.out.println("Login is successful !!");
      if ( homePage.HomePageLoad() ) {
        System.out.println("Home page loaded successfully !!");
        System.out.println("Help -> About -> Server version: " + homePage.ServerVersion());
      }
    }
  }

  @AfterClass
  public void teardown(){
    driver.close();
    driver.quit();
  }
}