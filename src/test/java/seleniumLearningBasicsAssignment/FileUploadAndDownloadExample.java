package seleniumLearningBasicsAssignment;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadAndDownloadExample {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();

		Map<String, Object> pref = new HashMap<>();
		String downloadPath = System.getProperty("java.io.tmpdir");
		System.out.println(downloadPath);
		String val = System.getProperty("user.dir") + File.separator + "externalFiles" + File.separator
				+ "downloadFiles";
		System.out.println(val);
		pref.put("download.default.directory", "C:\\Users\\rajeev\\Downloads");

		option.setExperimentalOption("prefs", pref);

		driver = new ChromeDriver(option);

		driver.get("https://demoqa.com/upload-download");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));

	}

	@Test
	public void test1() {
		driver.findElement(By.id("downloadButton")).click();

		Assert.assertTrue(isFileAvailable("sampleFile.jpeg", 60), "Downloaded document is not found");
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.close();
	}

	public boolean isFileAvailable(String fileName, int secondsToDownload) {
		try {
			Thread.sleep(secondsToDownload);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * String home = System.getProperty("user.home"); home = home + "/Downloads/";
		 */
		File folder = new File("C:\\Users\\rajeev\\Downloads");
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();

		for (File listOfFile : listOfFiles) {

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			if (listOfFile.isFile()) {
				if (listOfFile.getName().contains(fileName)) {
					System.out.println(listOfFile.getName());
					listOfFile.delete();
					return true;
				}
			}
		}
		return false;

	}
}
