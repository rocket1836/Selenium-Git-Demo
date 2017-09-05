package saucelabDemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class saucelabDemo {
	static WebDriver driver;

	public static final String USERNAME = "rocket_test";
	public static final String ACCESS_KEY = "9a276e08-34ae-435d-89b3-19fe205c622c";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	@Test
	public void firstTest() throws InterruptedException, MalformedURLException

	{
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows xp");
		caps.setCapability("name", "Using SauceLabs");
		caps.setCapability("version", "49.0");

		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50L, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("abhay@concret.io.training");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("c0ncret10");
		driver.findElement(By.xpath("//*[@id='Login']")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//*[@id='AllTab_Tab']")).click();
		driver.findElement(By.linkText("Accounts")).click();
		driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='acc2']")).sendKeys("saucelab1");
		driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]")).click();
		Thread.sleep(5000);
		driver.quit();

	}
}
