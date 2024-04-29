package com.example.2b2bWebApp;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestEditLoginInfo {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testEditLoginInfo() throws Exception {
    driver.get("http://ec2-3-14-13-63.us-east-2.compute.amazonaws.com/UserPlant");
    driver.findElement(By.linkText("view account page")).click();
    driver.get("http://ec2-3-14-13-63.us-east-2.compute.amazonaws.com/UserProfile");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | id=email | ]]
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("two@test.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/form/div[2]/div[2]")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [doubleClick | xpath=//div[@id='app']/div/div[2]/div[2]/form/div[2]/div[2] | ]]
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("abc");
    driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/button")).click();
    assertEquals("User Profile Updated", closeAlertAndGetItsText());
    driver.get("http://ec2-3-14-13-63.us-east-2.compute.amazonaws.com/UserPlant");
    driver.findElement(By.xpath("//div[@id='app']/div/button")).click();
    driver.get("http://ec2-3-14-13-63.us-east-2.compute.amazonaws.com/");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("two@test.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("abc");
    driver.findElement(By.xpath("//div[@id='app']/div/div/button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
