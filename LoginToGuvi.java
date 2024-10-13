package Task10;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginToGuvi {

public static void main(String[] args) throws InterruptedException {
	
	// Launch the ChromeDriver,Maximize the window and navigate to URL
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.guvi.in/");
			driver.manage().window().maximize();
			
			// Click the Sign-up Button for registration
			driver.findElement(By.xpath("//a[text()='Sign up']")).click();
			
			String title=driver.getTitle();
			if (title.equals("GUVI | Sign Up"))
				System.out.println("You are in the registration page and proceed");
			else
				System.out.println("Incorrect Page");
			
			// Filling the required details
			driver.findElement(By.id("name")).sendKeys("Sandy");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("fake.123@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("fake@123");
			driver.findElement(By.id("mobileNumber")).sendKeys("9999999999");
			driver.findElement(By.xpath("//a[@id='signup-btn']")).click();
			
			Thread.sleep(1000);
			String msg=driver.findElement(By.xpath("//div[@class='details-page-free details-custom-w']")).getText();
			System.out.println(" ");
			System.out.println(msg);
			
			driver.findElement(By.xpath("//select[@id='profileDrpDwn']")).click();
			driver.findElement(By.xpath("//option[@value='Looking for a career']")).click();
			driver.findElement(By.xpath("//select[@id='degreeDrpDwn']")).click();
			driver.findElement(By.xpath("//option[@value='B.E. / B.Tech. Mechanical Engineering']")).click();
			driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2024");
			
			// Wait for the page to load and verify the user is registered successfully 
			WebElement signupbtn=driver.findElement(By.id("details-btn"));	
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(signupbtn));
			signupbtn.click();
			System.out.println(" ");
			System.out.println("registered successfully");
			
			Thread.sleep(2000);
			String msg1=driver.findElement(By.className("left-head")).getText();
			System.out.println(" ");
			System.out.println(msg1);
			
			driver.navigate().refresh();
			
			// Login the Guvi portal
			driver.findElement(By.cssSelector(".login")).click();
		
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dummy.0123@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dummy@123");
			driver.findElement(By.xpath("//a[@id='login-btn']")).click();
			
			String msg2=driver.findElement(By.id("title")).getText();
			String msg3=driver.findElement(By.id("content")).getText();
			System.out.println(msg2);
			System.out.println(msg3);
			System.out.println(" ");
			System.out.println("logged in successfully");
			
			driver.close();   // Close the Driver

}
		
		}
