package testngdemo1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestNgDemo {
	@Test(priority=1,groups="Regression")
	public void loginPage() throws IOException {
		//login
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://magento.softwaretestingboard.com/?ref=hackernoon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		//registration
		driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[3]/a[1]\r\n")).click();
		driver.findElement(By.name("firstname")).sendKeys("Nancy Leema");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Karunakaran");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nancyleema.k0911@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Tharun@0911");
		driver.findElement(By.xpath("//input[@name='password_confirmation']")).sendKeys("Tharun@0911");
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]")).click();
		
		//signin
		driver.findElement(By.xpath("//header/div[1]/div[1]/ul[1]/li[2]/a[1]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("nancyleema.k0911@gmail.com");
		driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("Tharun@0911");
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[1]/div[2]/form[1]/fieldset[1]/div[4]/div[1]/button[1]")).click();
		//gettext
		WebElement textElement=driver.findElement(By.xpath(" //header/div[1]/div[1]/ul[1]/li[1]/span[1]"));
		String text = textElement.getText();
		System.out.println("Value:Welcome, Nancy Leema Karunakaran! " + text);
		
		//selecting the product from women->tops->jackets using mousehoveraction		
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Women')]"));
		action.moveToElement(element).build().perform();
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]")));
		WebElement element1=driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[2]"));
		action.moveToElement(element1).build().perform();
		
		
		driver.findElement(By.xpath("//*[@id=\"ui-id-11\"]/span")).click();
		
		//adding the product to cart
		driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]")).click();
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		System.out.println("loginPage");
		
		
		//takingscreenshot
		TakesScreenshot srcshot2=(TakesScreenshot)driver;
		File src2=srcshot2.getScreenshotAs(OutputType.FILE);
		File des2=new File("C:\\Users\\Admin\\Desktop\\screenshot\\snapshots.jpg");
		FileHandler.copy(src2, des2);
	
		driver.quit();
	
		driver.quit();
		
}

	
}
