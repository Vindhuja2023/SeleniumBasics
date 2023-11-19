package seleniumLearningBasicsAssignment;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWebTables {

	WebDriver driver;

	@BeforeMethod
	public void intialize() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();

	}

	@Test
	public void validatingWebTableElementText() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		List<WebElement> coloumns = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th"));
		System.out.println("Number of rows : " + rows.size());
		System.out.println("Number of rows : " + coloumns.size());

		String beforeXpath = "//table[@id='customers']/tbody/tr[";
		String afterXpath = "]/td[";
		String tableData = "";
		for (int i = 2; i <= rows.size(); i++) {
			for (int j = 1; j <= coloumns.size(); j++) {
				tableData = driver.findElement(By.xpath(beforeXpath + i + afterXpath + j + "]")).getText();
				if (tableData.equals("Italy")) {
					Assert.assertEquals(tableData, "Italy", "Element found from table is not as expected");
					break;
				}

			}

		}

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
