package Task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker {
	
	public static void main(String[] args) {

		// Launch the ChromeDriver,Maximize the window and navigate to URL
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Switch to frame
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);

		// Select the next month and date from datepicker
		WebElement datepick = driver.findElement(By.id("datepicker"));
		datepick.click();
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.linkText("27")).click();

		// Print the selected date from datepicker
		String selectedDate = datepick.getAttribute("value");
		System.out.println("Selected Date from the Date Picker : " + selectedDate);
		
		driver.close();   
		driver.quit();
	}


}
