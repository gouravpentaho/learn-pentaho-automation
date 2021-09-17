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

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the content on the Home perspective of Pentaho User Console
 */
public class HomePage {

  WebDriver driver;

  // ------------Create New----------------

  @FindBy( id = "btnCreateNew" )
  public WebElement btnCreateNew;

  @FindBy( id = "createNewanalyzerButton" )
  private WebElement btnCreateNewAnalyzerReport;

  @FindBy( id = "createNewinteractiveReportButton" )
  private WebElement btnCreateNewInteractiveReport;

  @FindBy( id = "createNewdashboardButton" )
  private WebElement btnCreateNewDashboard;

  @FindBy( id = "createNewdatasourceButton" )
  private WebElement btnCreateNewDataSource;

  @FindBy( id = "createNewlaunch_new_cdeButton" )
  private WebElement btnCreateNewCDEDashboard;

  @FindBy( id = "getting-started" )
  private WebElement gettingStartedBanner;

  @FindBy( xpath = "//button[contains(text(), 'Manage Data Sources')]" )
  private WebElement btnManageDataSources;

  @FindBy( id = "helpmenu" )
  private WebElement help;

  @FindBy( id = "aboutMenuItem" )
  private WebElement about;

  @FindBy( xpath = "//div[@class='gwt-Label'][contains(text(),'Release: ')]" )
  private WebElement version;

  public HomePage(WebDriver driver) {
    this.driver = driver;
    //This initElements method will create all WebElements
    PageFactory.initElements(driver, this);
  }

  public String ServerVersion() {
    String ver = null;
    help.click();
    about.click();
    ver = version.getText();
    return ver.substring(9);

  }

}
