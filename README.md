# learn-pentaho-automation
Sandbox for learning Pentaho Automation.

Prerequisite settings to run Selenium tests:

Step 1: Please follow standard Automation setup steps given on - https://hv-eng.atlassian.net/wiki/spaces/QA/pages/3033041259/Automation+Development+Environment+Setup

Step 2: Clone this repo to your VM or local where you have done automation setup.

Step 3: Go to website - http://chromedriver.storage.googleapis.com/index.html and download 93.0.4577.63 version or higher (pick as per your OS).
  
Step 4: Keep this file at some location which you can easily refer. (Example: C:\Users\username\driver\chromdriver.exe)

Step 5: Go to line no.46 in PUC_SmokeTest.java file and ensure to update the Chromedriver path as per folder location in your system (as per above step).

    //Setting system properties of ChromeDriver
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\gmudgal\\chromedriver\\chromedriver.exe");

Step 6: Go to Line no.52 in PUC_SmokeTest.java file and ensure to update the IP address, to reflect the Pentaho server which is currently running.

    // Launch Website
    driver.navigate().to("http://172.20.42.232:8080/pentaho/Login");

Step 7: In your IDE terminal run - mvn clean test
(Please ensure that Step1 was performed properly.)