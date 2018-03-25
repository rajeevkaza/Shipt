package org.shipt.signInTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

public class ShiptSignUpTest {
	WebDriver driver;
	public void setUp(){
		//Create Firefox Driver Instance
		System.setProperty("webdriver.chrome.driver","/Users/vkaza/Documents/workspace/ppccWebdriver/chromedriver");
		driver = new ChromeDriver();
	    	//System.setProperty("webdriver.firefox.marionette","/Users/vkaza/Documents/workspace/ppccWebdriver/geckodriver");
		 //driver = new FirefoxDriver();

	}

    @Test
    public void testShiptRegistration() {
    	String uname = "testShipt" + System.currentTimeMillis();
    	String uf = uname + "@digjij.com";

		 driver.get("https://shop.shipt.com/#/app/home");
    	System.out.println("Hello There");
    	 driver.findElement(By.cssSelector(".button-dark")).click();
    	 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread sleep exception");
			e.printStackTrace();
		}
    	 WebElement fullName = driver.findElement(By.cssSelector("input[ng-model='register.name']"));
         WebElement email = driver.findElement(By.cssSelector("input[ng-model='register.email']"));
         WebElement password = driver.findElement(By.cssSelector("input[ng-model='register.password']"));
         WebElement phone = driver.findElement(By.cssSelector("input[ng-model='register.phone']"));
         WebElement zip = driver.findElement(By.cssSelector("input[ng-model='register.zip']"));
         WebElement submit = driver.findElement(By.cssSelector("#signup_user_button"));

         fullName.sendKeys("Rajeev Kaza");
        email.sendKeys(uf);
        password.sendKeys("Shipt123!");
        phone.sendKeys("123-456-7890");
        zip.sendKeys("32204");
        submit.submit();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Thread sleep exception");
			e.printStackTrace();
		}
        assertEquals(true, driver.findElement(By.cssSelector("div.modal-wrapper-2:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div")).isDisplayed());;
    	driver.quit();

    }

    public void tearDown(){
    	driver.quit();
    }
}
