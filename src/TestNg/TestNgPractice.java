package TestNg;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.junit.*;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;


public class TestNgPractice {
	public WebDriver driver;
	
	
	@BeforeClass()
	public void setup() {
		
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C://Users//hai//Downloads//chromedriver_win32  (2)//chromedriver.exe");
		driver.get("http://live.techpanda.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	
	@Test()
	public void test1() {
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		String listpage = driver.findElement(By.xpath("//span[@id='product-price-1']")).getText();
		System.out.println(listpage);
		driver.findElement(By.xpath("//img[@id='product-collection-image-1']")).click();
		String detailspage = driver.findElement(By.xpath("//span[@class='price']")).getText();
		
		try {
			Assert.assertEquals(listpage, detailspage);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("exception is:" +e.getMessage());
		}
	}
		
	@Test()
	public void test2() {
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button/span/span")).click();
		WebElement qty = driver.findElement(By.xpath("//input[@type='text']"));
		qty.clear();
		qty.sendKeys("1000");
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		String error = driver.findElement(By.xpath("//p[@class='item-msg error']")).getText();
		System.out.println(error);
		String error2 = ("* The maximum quantity allowed for purchase is 500.");
		
		try{
			Assert.assertEquals(error, error2);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		driver.findElement(By.xpath("//span[text()='Empty Cart']")).click();
		String emp = driver.findElement(By.xpath("//h1[text()='Shopping Cart is Empty']")).getText();
		String emp1 = ("SHOPPING CART IS EMPTY");
		
		try {
			Assert.assertEquals(emp, emp1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		@Test()
		public void test3() {
		
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//span[text()='Compare']")).click();
		driver.switchTo().activeElement();
		if(driver.getPageSource().contains("Compare Products")) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
	}
		
		@Test()
		public void test4() {
			
			driver.findElement(By.xpath("//span[@class='icon']//preceding::span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Register']")).click();
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("venkata ramana");
			driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("varaprasad");
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("chilakamarthi");
			String random = RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
			driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(random);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Venkat@123");
			driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("Venkat@123");
			driver.findElement(By.xpath("//span[text()='Register']")).click();
			String str = "Thank you for registering with Main Website Store.";
			String str2 = driver.findElement(By.xpath("//span[text()='Thank you for registering with Main Website Store.']")).getText();
			
			try {
				Assert.assertEquals(str, str2);
			}catch(Exception e) {
				e.printStackTrace();
			}
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='TV']")).click();
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
			driver.findElement(By.xpath("//textarea[@name='emails']")).sendKeys("venkat.chilakamarthi@gmail.com");
			driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("television");
			driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
			String sl = driver.findElement(By.xpath("//span[text()='Your Wishlist has been shared.']")).getText();
			String sl2 = "Your Wishlist has been shared.";
			System.out.println(sl);
			System.out.println(sl2);
			driver.findElement(By.xpath("//span[@class='icon']//preceding::span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			

			try {
				Assert.assertEquals(sl, sl2);
			}catch(Exception e) {
				
				
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//span[@class='label']//preceding::span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
		}
		
		@Test()
		public void test5() {
			
			
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("venkat.chilakamarthi@gmail.com");
			driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Venkat@123");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			driver.findElement(By.xpath("//a[text()='TV']")).click();
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
			driver.findElement(By.xpath("//a[@class='link-edit button button-secondary']//preceding::span[text()='Add to Cart']")).click();  //add to cart
			
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button/span/span")).click();  //proceed to checkout
			driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//label[text()='Check / Money order ']")).click();
			driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//button[@title='Place Order']")).click();
			String str ="YOUR ORDER HAS BEEN RECEIVED.";
			String str1 = driver.findElement(By.xpath("//h1[text()='Your order has been received.']")).getText();
			driver.findElement(By.xpath("//span[@class='label']//preceding::span[text()='Account']")).click();
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			try {
				Assert.assertEquals(str, str1);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		@Test()
		public void test6() {
			driver.findElement(By.xpath("//span[@class='label']//preceding::span[text()='Account']")).click(); //click on Account link
			driver.findElement(By.xpath("//a[text()='Log In']")).click();
			driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("venkat.chilakamarthi@gmail.com");
			driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Venkat@123");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/span/a[2]")).click();
			String grand  = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span")).getText();
			System.out.println(grand);
			driver.findElement(By.xpath("//input[@title='Qty']")).clear();
			driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("3");
			driver.findElement(By.xpath("//span[text()='Update']")).click();
			String grand1 = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span")).getText();
			System.out.println(grand1);
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[1]/ul/li/button/span/span")).click();  //proceed to checkout
			driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//label[text()='Check / Money order ']")).click();
			driver.findElement(By.xpath("//*[@id=\"payment-buttons-container\"]/button/span/span")).click();
			driver.findElement(By.xpath("//button[@title='Place Order']")).click();
			String str ="YOUR ORDER HAS BEEN RECEIVED.";
			String str1 = driver.findElement(By.xpath("//h1[text()='Your order has been received.']")).getText();
		
			try {
				Assert.assertEquals(str, str1);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		@Test()
		public void test7() throws InterruptedException {
			driver.findElement(By.xpath("//span[@class='label']//preceding::span[text()='Account']")).click(); //click on Account link
			driver.findElement(By.xpath("//a[text()='Log In']")).click();
			driver.findElement(By.xpath("//input[@title='Email Address']")).sendKeys("venkat.chilakamarthi@gmail.com");
			driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("Venkat@123");
			driver.findElement(By.xpath("//span[text()='Login']")).click();
			driver.findElement(By.xpath("//a[text()='Mobile']")).click();
			driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
			driver.switchTo().defaultContent();
			String price = driver.findElement(By.xpath("//span[text()='$500.00']")).getText().replace("$"," ");
			driver.findElement(By.xpath("//input[@id='coupon_code']")).sendKeys("GURU50");
			driver.findElement(By.xpath("//span[text()='Apply']")).click();
			String price1 = driver.findElement(By.xpath("//strong//span[text()='$500.00']")).getText().replace("$"," ");
	
			
			if(price!=price1) {
				System.out.println("Test passed");
			}else {
				System.out.println("Test failed");
			}
		}
	   @AfterClass()
	   public void teardown() {
		driver.quit();
	}
		
  }
