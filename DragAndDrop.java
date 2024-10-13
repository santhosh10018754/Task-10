package Task10;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class DragAndDrop {
	
	public static void main(String[] args) {

		// Launch the ChromeDriver,Maximize the window and navigate to URL
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		// Switch to frame
		WebElement frameElement = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frameElement);

		WebElement SourceElement = driver.findElement(By.id("draggable"));
		String element1size = SourceElement.getCssValue("background-color");
		System.out.println("Source Element colour : " + element1size);
		
		WebElement TargetElement = driver.findElement(By.id("droppable"));
		String element2size = TargetElement.getCssValue("background-color");
		System.out.println("Target Element colour : " + element2size);

		// Dragging SourceElement and dropping to TargetElement
		Actions objAct = new Actions(driver);
		objAct.dragAndDrop(SourceElement, TargetElement).build().perform();

		String message = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		Assert.assertEquals("Dropped!", message);
		System.out.println(" ");
		System.out.println("Message verfied and Test successful");

		String element2color = TargetElement.getCssValue("background-color");
		System.out.println(" ");
		System.out.println("After Drag and Drop colour is : " + element2color);

		String text = TargetElement.getText();

		if (text.equalsIgnoreCase("Dropped!")) {
			System.out.println(" ");
			System.out.println("Pass : Source is dropped to target as expected");
		} else
			System.out.println("Fail : Source couldn't be dropped to target as expected");
	}


}
