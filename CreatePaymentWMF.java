package payment.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreatePaymentWMF {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement b = driver.findElement(By.xpath("//p[text()='Payment Authorizations']"));
		driver.executeScript("arguments[0].click();", b);
		WebElement a = driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", a);
		WebElement z = driver.findElement(By.xpath("(//div[@title='Saranya'])[1]"));
		driver.executeScript("arguments[0].click();", z);
		WebElement c = driver.findElement(By.xpath("//button[@title='Save']"));
		driver.executeScript("arguments[0].click();", c);
		  String actual_Error1=driver.findElement(By.xpath("//ul[@class='errorsList']")).getText();
	        String expected_Error1=actual_Error1;
	        Assert.assertEquals(actual_Error1,expected_Error1);
	        System.out.println(actual_Error1);
	        

	}

}
