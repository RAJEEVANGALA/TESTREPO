//package selenium_4_5;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;


public class EBS_SiteHub {

	public static void main(String args[]) throws Exception {
		
		File currentDir = new File(".");
		 
		 // currDir : D:\DOCUMENTS\SELENIUM_PROJECTS\Webdriver_Projects\OracleEBS\
//		String serverPath =  currentDir.getAbsolutePath().replace(".", "")+"browserLibs\\";
		String serverPath =   currentDir.getAbsolutePath().replace(".", "")+"Browser\\";
		String jsPath 	  =  currentDir.getAbsolutePath().replace(".", "")+"Others\\DragAndDrop.js";
		 
		System.out.println("serverPath:"+serverPath);

		System.setProperty("webdriver.gecko.driver", serverPath+"geckodriver.exe");
		
//		System.setProperty("webdriver.chrome.driver", serverPath+"chromedriver.exe");
		 
		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver();
				
		// Set the Settings
		// Object Wait Time
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
								
		// Page Load Wait Time
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
//		driver.get("http://rws3511456.us.oracle.com:8000/OA_HTML/AppsLogin");
//		driver.get("https://aojmu210.ad1.fusionappsdphx1.oraclevcn.com:4443/");
		driver.get("https://aztmu210.appsdev0.fusionappsdphx1.oraclevcn.com:4443/OA_HTML/AppsLocalLogin.jsp");
		
		driver.findElement(By.id("usernameField")).sendKeys("plmmgr");
		
		driver.findElement(By.id("passwordField")).sendKeys("welcome");
		
		
		driver.findElement(By.xpath("//button[text()='Log In']")).click();
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//table[@id='mainMenuRegion']/descendant::li/descendant::div[text()='Site Management User']")).click();
		
		
		driver.findElement(By.xpath("//table[@id='mainMenuRegion']/descendant::li/descendant::li/descendant::div[text()='Site Management User']")).click();
		
		
		driver.findElement(By.xpath("//table[@id='mainMenuRegion']/descendant::li/descendant::li/descendant::li/descendant::div[text()='Site Home']")).click();
		
		
				
		driver.findElement(By.id("RRS_HIERARCHIES_TAB_MENU")).click();
		
		driver.findElement(By.id("RRS_HIERARCHIES_WB_SUB_TAB")).click();
		
		Thread.sleep(10000);
		
		/*List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("iframes:"+iframes.toString());
		
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		System.out.println("frames:"+frames.toString()); */
		
		driver.switchTo().frame(1);
		
		driver.findElement(By.id("addHierBtnImg")).click();
		
		driver.findElement(By.xpath("//input[@aria-label = 'Hierarchy search field']")).sendKeys("Retail Hierarchy");

		driver.findElement(By.xpath("//img[@alt = '[[srchBtnText]]']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//td[contains(@id,'searchPopupTable:_hdrCol0')]/oj-selector/span/input")).click();
		
		driver.findElement(By.id("btnSelectHier")).click();
		

		Thread.sleep(10000);
		
		driver.findElement(By.id("addHierBtnImg")).click();
		
		driver.findElement(By.xpath("//input[@aria-label = 'Hierarchy search field']")).sendKeys("RGH-Sanity01");

		driver.findElement(By.xpath("//img[@alt = '[[srchBtnText]]']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//td[contains(@id,'searchPopupTable:_hdrCol0')]/oj-selector/span/input")).click();
		
		driver.findElement(By.id("btnSelectHier")).click();
		
		Thread.sleep(30000);
		
		// Drag and Drop- R
		
//		WebElement  drag = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//table/tbody/tr[1]/td[text()='Retail Hierarchy']")));
//		WebElement  drop = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id,'treeview_0']/div")));
//		new Actions(driver).dragAndDrop(drag, drop).build().perform();
		
//		WebElement From = driver.findElement(By.xpath("//table/tbody[@class='oj-table-body']/tr[1]/td[text()='Retail Hierarchy']"));

		WebElement From = driver.findElement(By.xpath("//oj-table[@id='hierListTbl']/table/tbody/tr[1]"));
		
		WebElement To = driver.findElement(By.xpath("//li[@id='treeview_0']/div"));
		WebElement To1 = driver.findElement(By.xpath("//li[@id='treeviewPane2_0']/div"));
		
		
//		WebElement To2 = driver.findElement(By.xpath("//li[@id='treeview_0']//span[@id='pane1_10040']"));
//		WebElement To3 = driver.findElement(By.xpath("//li[@id='treeviewPane2_0']//span[@id='pane2_11144']"));
		
		To1.click();
		
		To.click();
		
//		From.click();
		
		Thread.sleep(5000);
		
//		BufferedReader br = new BufferedReader(new FileReader(jsPath)); 
//        
//        StringBuilder sb = new StringBuilder(); 
//        String line = br.readLine(); 
//        while (line != null) 
//        { 
//        	sb.append(line).append("\n"); 
//        	line = br.readLine(); 
//        } 
//        
//        String script = sb.toString();
//
//        script = script + "  executeDrageAndDrop(arguments[0], arguments[1])";
//        
//        System.out.println(script);
//		
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//
//
//		executor.executeScript(script, To, To1);
//		
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("$(arguments[0]).simulate('drag-n-drop',{dragTarget:arguments[1],interpolation:{stepWidth:100,stepDelay:50}});", From, To);
//		
//		new Actions(driver).dragAndDrop(From, To).release().build().perform();
//	    Robot robot = new Robot();
//	    robot.keyPress(KeyEvent.VK_ESCAPE);
//	    robot.keyRelease(KeyEvent.VK_ESCAPE);
		
//		int x = To.getLocation().x;
//        int y = To.getLocation().y;
//        
//        System.out.println ("*******"+x);
//        System.out.println ("*******"+y);
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(From)
//                .pause(1)
//                .clickAndHold(From)
//                .pause(1)
//                .moveByOffset(x, y)
//                .moveToElement(To)
//                .moveByOffset(x,y)
//                .pause(1)
//                .release().build().perform();
		
		Actions act=new Actions(driver);
//		act.clickAndHold(From).moveToElement(To).build().perform();
		act.dragAndDrop(To, To1).perform();
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
//				                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
//				                    + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
//				                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
//				                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
//				                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
//				                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
//				                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
//				                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
//				                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
//				                    + "var dropEvent = createEvent('drop');\n"
//				                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
//				                    + "var dragEndEvent = createEvent('dragend');\n"
//				                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
//				                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
//				                    + "simulateHTML5DragAndDrop(source,destination);", From, To);
//		
//		    
//		    //HTML 5
//		            final String java_script =
//		                    "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
//		                            "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
//		                            "ction(format,data){this.items[format]=data;this.types.append(for" +
//		                            "mat);},getData:function(format){return this.items[format];},clea" +
//		                            "rData:function(format){}};var emit=function(event,target){var ev" +
//		                            "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
//		                            "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
//		                            "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
//		                            "'drop',tgt);emit('dragend',src);";
//		    
//		    ((JavascriptExecutor)driver).executeScript(java_script, From, To,);
		
//		var dragAndDrop = require('html-dnd').code;
//		var webdriver = require('selenium-webdriver');
//		var By = webdriver.By;
//
//		var driver = new webdriver.Builder()
//		  .forBrowser('firefox')
//		  .build();
//
//		driver.get('http://example.com');
//
//		var draggable = driver.findElement(By.id('draggable'));
//		var droppable = driver.findElement(By.id('droppable'));
//
//		driver.executeScript(dragAndDrop, draggable, droppable);
//
//		driver.quit();
		
		// Drag and Drop
//		
//		WebElement from = driver.findElement(By.xpath("//oj-table[@id='hierListTbl']/descendant::table/tbody/tr[1]"));
//		
//		from.click();
//		
//		Thread.sleep(5000);
//		
//		
//		//WebElement from1 = driver.findElement(By.xpath("//oj-table[@id='hierListTbl']/descendant::table/tbody/tr"));
//		
//		//WebElement to = driver.findElement(By.xpath("//oj-tree-view[@id='treeview']/descendant::ul/li/div/span[@id='pane1_-1']"));
//		
//		WebElement from1 = driver.findElement(By.xpath("//oj-table[@id='hierListTbl']/descendant::table/tbody/tr[1]/td"));
//		WebElement to = driver.findElement(By.xpath("//oj-tree-view[@id='treeview']/descendant::ul/li"));
//		
//			
//		System.out.println("to address given");
//		
//		//Using Action class for drag and drop.		
//        Actions act=new Actions(driver);					
//
//        //Dragged and dropped.	
//        act.dragAndDrop(from1, to).build().perform();	
       // act.dragAndDrop(from, to).release().build().perform();	
        
      /*  Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);*/
        
		/* int x = to.getLocation().x;
	     int y = to.getLocation().y;
        
        Actions actions = new Actions(driver);
        actions.moveToElement(from)
                .pause(Duration.ofSeconds(1))
                .clickAndHold(from)
                .pause(Duration.ofSeconds(1))
                .moveByOffset(x, y)
                .moveToElement(to)
                .moveByOffset(x,y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
        */
        
        
        // read file as String in Java SE 6 and lower version 
       /* BufferedReader br = new BufferedReader(new FileReader(jsPath)); 
        
        StringBuilder sb = new StringBuilder(); 
        String line = br.readLine(); 
        while (line != null) 
        { 
        	sb.append(line).append("\n"); 
        	line = br.readLine(); 
        } 
        
        String script = sb.toString();

        script = script + "  executeDrageAndDrop(arguments[0], arguments[1])";
        
        System.out.println(script);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        js.executeScript(script,from, to);*/
        
	}
	
	
}
