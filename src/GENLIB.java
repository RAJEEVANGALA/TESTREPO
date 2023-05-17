import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class GENLIB {
	public static WebDriver driver;

	public static void main(String Args[]) throws Exception{
		
		String browser = "chrome";

		if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", "C:\\WORK\\SELENIUM\\workspace\\EBSAutomation\\Browser\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);// We need to set this value based on browser version

			driver = new FirefoxDriver(options);

		} else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\WORK\\SELENIUM\\workspace\\EBSAutomation\\Browser\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();// use options in the ChromeDriver()

			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\WORK\\SELENIUM\\workspace\\EBSAutomation\\Browser\\MicrosoftWebDriver.exe");

			EdgeOptions options = new EdgeOptions();// use options in the EdgeDriver()

			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("ie")) {// old

			System.setProperty("webdriver.ie.driver", "C:\\WORK\\SELENIUM\\workspace\\EBSAutomation\\Browser\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		}

		
		
		// Object Wait Time
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Page Load Wait Time
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		//Maximize Window
		driver.manage().window().maximize();

		// Coding
		driver.get("http://rws3260325.us.oracle.com:8000/OA_HTML/AppsLogin");		
		driver.findElement(By.id("usernameField")).sendKeys("operations");
		driver.findElement(By.id("passwordField")).sendKeys("welcome");
		driver.findElement(By.xpath("//*[@id='ButtonBox']/button[contains(text(),'Log In')]")).click();
		Thread.sleep(20000);
		
		
//		driver.findElement(By.xpath("//table[@id='respList']//ul/li[136]")).click();
//		driver.findElement(By.xpath("//table[@id='respList']//ul/li//div[2][starts-with(text(),'iProcurement')][1]")).click();
		
		
		//*[@id="64188:542:-1:0:mainMenuRESTf7Bjz31T"]/a/div[2]
		
		driver.findElement(By.xpath("//table[@id='respList']//ul/li[177]")).click();
		driver.findElement(By.xpath("//table[@id='respList']//ul/li[177]/ul/li[1]")).click();
		driver.findElement(By.xpath("//table[@id='respList']//ul/li[177]/ul/li[1]/ul/li[2]")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//button[@id='CreateCtrTemplate']")).click();
//		Thread.sleep(5000);
				
		
		GENLIB genlib=new GENLIB();					
//		genlib.navigate_OAF("Oracle Installed Base Agent User","Counters","Counter Instances",driver);
//		genlib.webClickButton("View Cart and Checkout");
		genlib.webClickButton("Create");
		Thread.sleep(5000);

//		genlib.setValueBasedonLabelAfterUIComponent("Direction", "select", "Ascending");
//		genlib.setValueBasedonLabelAfterUIComponent("Use In Scheduling", "checkbox", "true");
		
		String output=genlib.getValueBasedonLabelBeforeUIComponent("Status", "input");

		System.out.println("Value : "+output);
		output=genlib.getValueBasedonLabelBeforeUIComponent("Party Type", "select");

		System.out.println("Value : "+output);
		output=genlib.getValueBasedonLabelBeforeUIComponent("&nbsp;Organization Name", "input");

		System.out.println("Value : "+output);
		
//		genlib.webClickImage("Add Another Row: Item Associations");
		
		}
		
//		public void navigate_OAF(String respName,String category, String subCategory, WebDriver driver) {
//		
//		By respListPath= By.xpath("//table[@id='respList']//ul/li");
//		List<WebElement> respList = driver.findElements(respListPath);
//		
//		for(WebElement resp:respList) {
//
//		String actRespName=resp.findElement(By.xpath(".//div[2]")).getText();
//		System.out.println(actRespName);
//		if (actRespName.equalsIgnoreCase(respName)) {
//			resp.findElement(By.xpath(".//div[2]")).click();
//			if (category!=""){
//				List <WebElement> categoryList=resp.findElements(By.xpath(".//ul/li"));
//				for(WebElement cat:categoryList) {
//					String actCategoryName=cat.findElement(By.xpath(".//div[2]")).getText();
//					if (actCategoryName.equalsIgnoreCase(category)) {
//						cat.findElement(By.xpath(".//div[2]")).click();
//					}
//				}
//				
//			}
//			if (subCategory!=""){
//				List <WebElement> subCategoryList=resp.findElements(By.xpath(".//ul/li"));
//				for(WebElement subCat:subCategoryList) {
//					String actSubCategoryName=subCat.findElement(By.xpath(".//div[2]")).getText();
//					if (actSubCategoryName.equalsIgnoreCase(subCategory)) {
//						subCat.findElement(By.xpath(".//div[2]")).click();
//					}
//				}
//			}
//			
//			
//			System.out.println("**********Responsibility Found****************");
//			break;
//		}
//		
//		}
//	}
		
	public void webClickButton(String buttonName) throws Exception {
		
		System.out.println("****** Start of webClickButton *********************** ");
		
		boolean buttonFound=false;
		int buttonIndex=0;
		String expButtonName = "";
		String fireevent = "";
		int i=0;
	
		String buttonPathDetails[] = buttonName.split(",");	

		// Get the Button Details passed from User
		for (int index = 0; index < buttonPathDetails.length; index++) {

			if (!buttonPathDetails[index].contains("document=") && !buttonPathDetails[index].contains("form=") && 
					!buttonPathDetails[index].contains("input")&& !buttonPathDetails[index].contains("type") && !buttonPathDetails[index].contains("fireevent")) {

				String[] buttonDetails = buttonPathDetails[index].split(";");

				// Similar Button Index
				if (buttonDetails.length > 1) 
				{
					
					buttonIndex = Integer.parseInt(buttonDetails[1]);
				}

				// Button Name
				expButtonName = buttonDetails[0];
				System.out.println("expButtonName>>"+ expButtonName);

			}else if (buttonPathDetails[index].trim().startsWith("fireevent=")) 
			{
				fireevent = buttonPathDetails[index].split("=")[1];
			}
		}
		
		
		//To get pop up if any exists
//		String frameid=getProperty("FrameID");
//		System.out.println("*****frame id is "+frameid);		
		
		//To move to Pop up if exists
//		if(frameid!="") {
//			driver.switchTo().frame(frameid);
//		}
		
		//To find button in the elements with tag= button
		By buttonPath=By.xpath(".//button");
		buttonFound=clickButton(buttonPath,buttonName,buttonIndex);
		
		//To find button in the elements with tag= input 
		if (!buttonFound) {
			buttonPath=By.xpath(".//input[@type='button' or @type='submit' or @type='reset']");
			buttonFound=clickButton(buttonPath,buttonName,buttonIndex);
		}
	
		
		if (!buttonFound) {
			System.out.println("Unable to find the button : "+buttonName);
		}
		
		driver.switchTo().defaultContent();	
		
		System.out.println("****** End of webClickButton *********************** ");
		
	}
	
	private boolean clickButton(By buttonPath, String buttonName, int buttonIndex ){
		
		boolean buttonFound=false;
		int actualButtonIndex=0;
		
		List <WebElement> buttonsList=driver.findElements(buttonPath);
		for(WebElement button:buttonsList) {
				System.out.println(button.getText());
				
				
				String value=button.getText();
				
				if (value=="") {
					value=button.getAttribute("value");
				}
				if (value=="") {
					value=button.getAttribute("title");
				}
				
				//To remove invalid characters from the value
				
				while (value.contains("<"))
				{
					int StartIndex = value.indexOf('<');
					int closeIndex = value.indexOf('>');
					value = value.replace(value.substring(StartIndex,closeIndex + 1),"");

				}
				
				value.trim().replaceAll("([\\s]+)([\\s]+)", "");
				
				//Start of Removing text of script tag -- IE9 Change
				List<WebElement> scriptElementsList = button.findElements(By.xpath(".//script"));
				
				for(WebElement scriptElement:scriptElementsList){
					
					String scriptText = "";
					scriptText = scriptElement.getText();
					
					if(scriptText != null){
						value = value.replace(scriptText, "");
					}	
				}
				//End of Removing text of script tag -- IE9 Change
				
			
				if (buttonName.trim().equalsIgnoreCase(value.trim())) {
					
					if (buttonIndex==actualButtonIndex) {
						buttonFound=true;
						button.click();
						System.out.println("Clicked on Button: "+buttonName);
						break;
					}
					actualButtonIndex++;
					
				}
				
			}
		return buttonFound;
			
		}
	


public String getValueBasedonLabelBeforeUIComponent(String labelName, String compType) throws Exception {
	
	WebElement parentElement=driver.findElement(By.xpath("//span[text()='"+labelName+"']//parent::td/following-sibling::td[2]"));
	
	System.out.println("xpath : "+"//span[text()='"+labelName+"']//parent::td/following-sibling::td[2]");
	
	String returnValue = null;
	
	if (compType.equalsIgnoreCase("select")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//select[1]"));
		Select dropdown= new Select(driver.findElement(By.id(element.getAttribute("id"))));
		WebElement selectedElement=dropdown.getFirstSelectedOption();
		returnValue=selectedElement.getText();
	    
	}
	if (compType.equalsIgnoreCase("textArea")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//textArea[1]"));
		returnValue=element.getAttribute("value");
		
	}
	if (compType.equalsIgnoreCase("input")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		returnValue=element.getAttribute("value");
		
	}

	if (compType.equalsIgnoreCase("checkbox")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		boolean theValue=element.isSelected();	
		returnValue=String.valueOf(theValue);

	}

	return returnValue;
}	

public String getValueBasedonLabelAfterUIComponent(String labelName, String compType) throws Exception {	
	
	WebElement parentElement=driver.findElement(By.xpath("//span[text()='"+labelName+"']//parent::td"));
	
	System.out.println("xpath : "+"//span[text()='"+labelName+"']//parent::td");
	
	String returnValue = null;
	
	if (compType.equalsIgnoreCase("select")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//select[1]"));
		Select dropdown= new Select(driver.findElement(By.id(element.getAttribute("id"))));
		WebElement selectedElement=dropdown.getFirstSelectedOption();
		returnValue=selectedElement.getText();
	    
	}
	if (compType.equalsIgnoreCase("textArea")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//textArea[1]"));
		returnValue=element.getAttribute("value");
		
	}
	if (compType.equalsIgnoreCase("input")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		returnValue=element.getAttribute("value");
		
	}

	if (compType.equalsIgnoreCase("checkbox")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		boolean theValue=element.isSelected();	
		returnValue=String.valueOf(theValue);
	}
	
	return returnValue;
	
}	
public boolean verifyValueBasedonLabelBeforeUIComponent(String labelName, String compType, String expectedValue) throws Exception {

	WebElement parentElement=driver.findElement(By.xpath("//span[text()='"+labelName+"']//parent::td/following-sibling::td[2]"));
	
	System.out.println("xpath : "+"//span[text()='"+labelName+"']//parent::td/following-sibling::td[2]");
	
	String actualValue = null;
	boolean found = false;

	if (compType.equalsIgnoreCase("select")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//select[1]"));
		Select dropdown= new Select(driver.findElement(By.id(element.getAttribute("id"))));
		WebElement selectedElement=dropdown.getFirstSelectedOption();
		actualValue=selectedElement.getText();
	    
	}
	if (compType.equalsIgnoreCase("textArea")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//textArea[1]"));
		actualValue=element.getAttribute("value");
		
	}
	if (compType.equalsIgnoreCase("input")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		actualValue=element.getAttribute("value");
		
	}
	if (compType.equalsIgnoreCase("checkbox")) {
		
		WebElement element=parentElement.findElement(By.xpath(".//input[1]"));
		boolean theValue=element.isSelected();	
		actualValue=String.valueOf(theValue);

	}


	if (actualValue.equals(expectedValue)) {
		
		System.out.println("PASSED: actualValue:\"" + actualValue + "\" is same as the expected value:\"" + expectedValue + "\"");
		found = true;
		
	} else {
		
		System.out.println("FAILED: actualValue:\"" + actualValue + "\" is NOT same as the expected value:\"" + expectedValue + "\"");
		found = false;
		
	}
	
	return found;
	
}

public String  getExpenditureGroup(String index) throws Exception {
	
	int expGrpIndex = toInt(index.trim())-1;
	
	
	String path ="";
	
	
	String parentWindowHandle = driver.getWindowHandle();
			
    Set<String> windowSet = driver.getWindowHandles();
    Iterator<String> windowIterator = windowSet.iterator();
    while (windowIterator.hasNext()) {
        String windowHandle = windowIterator.next();
        System.out.println(windowHandle);
        
        //To Switch to OUTPUT window
        
        if (!parentWindowHandle.equals(windowHandle)) {
            driver.switchTo().window(windowHandle);
            if(driver.findElement(By.xpath("//pre")).isDisplayed()) {
            	break;
            }
        }
    }
    
    
	String output = driver.findElement(By.xpath("//pre")).getText();
	
	
	//To switch back to Parent Window
	driver.switchTo().window(parentWindowHandle);
	
	int startIndex = output.indexOf("Expenditure Group");
	int endIndex = output.indexOf("Total Expenditure Groups Created");
	
	String substring = output.substring(startIndex, endIndex);
	substring = 	substring.replace("Expenditure Group", "");
	substring = 	substring.replaceAll("Ending Date", "");
	substring = 	substring.replaceAll("Number of Expenditures", "");
	
	substring = 	substring.replaceAll("-", "");
	substring = 	substring.replaceAll("\n", "");
	substring = 	substring.replaceAll("  ", "");
	substring = 	substring.replaceAll("\t", "");
	/*substring = 	substring.replace("Expenditure Group", "");
	substring = 	substring.replaceAll("Ending Date", "");
	substring = 	substring.replaceAll("Number of Expenditures", "");*/
	substring = 	substring.replaceAll(substring.substring(substring.indexOf("Sum"),substring.length() ),"");
	System.err.println(substring);
	
	String [] mylist = substring.trim().split(" ");
	
	List<String> expgrpList = Arrays.asList(mylist);
	
	if(expGrpIndex>0){
		
		return expgrpList.get(expGrpIndex+2);
	}else{
		
		return expgrpList.get(0);
	}
}

public boolean webVerifyAttributes(String xpath, String attr, String expectedValue) throws Exception {
	boolean verified = false;
	
	if (driver.findElement(By.xpath(xpath)).getAttribute(attr).equals(expectedValue)) {
		verified = true;
		System.out.println("The text matches with the expected value");
	}
	else {
		warn("The text doesn't match with the expected value");
	}
	
	return verified;
}


public void selectSearchRadioOption(String radioOption) throws Exception {
	
	String windowindex = web.getFocusedWindow().getAttribute("index");
	String windowTitle= web.getFocusedWindow().getTitle();
	String windowPath="/web:window[@index='"+windowindex+"' or @title='"+windowTitle+"']";
	int currentWindowIndex =Integer.parseInt(web.window(windowPath).getAttribute("index"));
	String docPath=windowPath+"/web:document[@index='"+currentWindowIndex+"']";	
	int indexSelection=0;
	
		if(radioOption.equalsIgnoreCase("True")){
			driver.findElement(By.xpath("//input[@name='advancedSearchRadioGroup']")).click();
		
			indexSelection=1;  // Search option index for When any conditions is met
		}
		else /*if(radioOption.equalsIgnoreCase("when any condition is met"))*/{
			indexSelection=0; // Search option index for When all conditions are met
		}
	
	String xpath =docPath+"/web:form[ @index='0']/web:input_radio[(@name='advancedSearchRadioGroup') and @index='"+indexSelection+"']";
	
	
	web.radioButton(xpath).select();	
	
}

	
public void addAttachments(String[] fieldLabels , String[] fieldValues, String action) throws Exception{
	
	/* Convert Data from Arrays to Lists*/
	List<String> lFieldLabels = Arrays.asList(fieldLabels);
	List<String> lFieldValues = Arrays.asList(fieldValues);
	
	/* Set "title" field */
	if(lFieldLabels.contains("Title")){
		
		String title = lFieldValues.get(lFieldLabels.indexOf("Title"));
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Title_textfield}}")).wait();
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Title_textfield}}")).sendKeys(title);
	}
	
	/* Set "Description" field */
	if(lFieldLabels.contains("Description")){
		
		String description = lFieldValues.get(lFieldLabels.indexOf("Description"));
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Description_textarea}}")).wait();
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Description_textarea}}")).sendKeys(description);
	}
	
	
	/* Select "Category" field */
	if(lFieldLabels.contains("Category")){
		
		String category = lFieldValues.get(lFieldLabels.indexOf("Category"));
		
		Select dropdown= new Select(driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Category_select}}")));
		dropdown.wait();
		dropdown.selectByVisibleText(category);
	}
	
	/* Select "Attachment" field */
	if(lFieldLabels.contains("AttchmentType")){
		
		String attachmentType = lFieldValues.get(lFieldLabels.indexOf("AttchmentType"));
		String attachmentVallue = lFieldValues.get(lFieldLabels.indexOf("AttchmentValue"));
		
		if(attachmentType.equalsIgnoreCase("file")){
			
			/* Select File Radio button */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_File_radiobutton}}")).click();
			
			/* click File Text Field */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_File_textfield}}")).wait();
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_File_textfield}}")).click();
			
			
			/* Set the text in Open Dialog Box */
			
			web.dialog("{{obj.PROCLIB.web_dialog_unknown_Look__in_}}").waitFor(SYNCTIME);
			web.dialog("{{obj.PROCLIB.web_dialog_unknown_Look__in_}}").setText(0, attachmentVallue);
			
			/* Clcik on Open button */
			web.dialog("{{obj.PROCLIB.web_dialog_unknown_Look__in_}}").clickButton(0);
			
			/* Set the Focus to File Text Field */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_File_textfield}}")).click();
			
		}else if(attachmentType.equalsIgnoreCase("url")){
			
			/* Select URL Radio button */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_URL_radiobutton}}")).click();
			
			/* click URL Text Field */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_URL_textfield}}")).wait();
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_URL_textfield}}")).sendKeys(attachmentVallue);
			
		}else if(attachmentType.equalsIgnoreCase("text")){
			
			/* Select Text Radio button */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_TEXT_radiobutton}}")).click();
			
			/* click Text Text Area */
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Text_textarea}}")).wait();
			driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Text_textarea}}")).sendKeys(attachmentVallue);
		}
		
	}
	
	if(action.equalsIgnoreCase("apply")){
		

		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Apply_button}}")).wait();
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_Apply_button}}")).click();
		
		
	} else if(action.equalsIgnoreCase("add another")){
		

		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_AddAnother_button}}")).wait();
		driver.findElement(By.id("{{obj.PROCLIB.web_AddAttachment_AddAnother_button}}")).click();
		
		/* Wait for Add Attachment page to load  */
		Thread.sleep(20000);
		
	}
	
}





}