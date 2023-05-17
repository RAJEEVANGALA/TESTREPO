import java.io.File;
import java.util.Map;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Practice {
	
	public static void main(String args[]) throws Exception {
	
		File currentDir = new File(".");
		 
		 // currDir : D:\DOCUMENTS\SELENIUM_PROJECTS\Webdriver_Projects\OracleEBS\
//		String serverPath =  currentDir.getAbsolutePath().replace(".", "")+"browserLibs\\";
		String serverPath =   currentDir.getAbsolutePath().replace(".", "")+"Browser\\";
		String jsPath 	  =  currentDir.getAbsolutePath().replace(".", "")+"Others\\DragAndDrop.js";
		 
		System.out.println("serverPath:"+serverPath);

//		System.setProperty("webdriver.gecko.driver", serverPath+"geckodriver.exe");
		
		System.setProperty("webdriver.chrome.driver", serverPath+"chromedriver.exe");
		int port =54433; 
//		WebDriver driver = new FirefoxDriver();		

		ChromeOptions options= new ChromeOptions();
		WebDriver driver;
		
		if (port ==0) {
		driver= new ChromeDriver();
		}
		else {
		options.setExperimentalOption("debuggerAddress", "localhost:"+port);

		driver = new ChromeDriver(options);
		}
		
		Capabilities cap= ((ChromeDriver)driver).getCapabilities();
		
		Map <String, Object> m = cap.asMap();
		
		System.out.println(m.get("goog:chromeOptions"));
		
//		driver.get("http://mz2r2213.appsdev1.fusionappsdphx1.oraclevcn.com:8000/OA_HTML/AppsLogin");
		
driver.findElement(By.id("usernameField")).sendKeys("operations");
		
		driver.findElement(By.id("passwordField")).sendKeys("welcome");
		
	}

}
