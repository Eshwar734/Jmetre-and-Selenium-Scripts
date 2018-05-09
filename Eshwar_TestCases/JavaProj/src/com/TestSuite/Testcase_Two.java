package com.TestSuite;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Config.Constants;
import com.Pages.PageObjects;

public class Testcase_Two extends Constants {

	@Test
	public void TC_2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		String URl1 = "http://automationpractice.com/";
		driver.manage().window().maximize();

		driver.get(URl1);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageObjects site = PageFactory.initElements(driver, PageObjects.class);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		site.Sign(wait);

		Thread.sleep(5000);

		// search-- condition 1
		site.search_query(wait);
		System.out.println("condition 1 passed");
		Thread.sleep(3000);

		// links-- condition 2
		site.linkTest();
		System.out.println("condition 2 passed");
		Thread.sleep(3000);

		// Add to cart---condition 3
		site.addItemCart();
		System.out.println("condition 3 passed");
		
		
		Thread.sleep(3000);
		
		driver.quit();

	}
}