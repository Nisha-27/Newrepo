package modelncontactdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data {
		
	static WebDriver driver;
	// static String utilpath ="D:\\excel\\Testdata.xlsx";
	public static String siteurl = null;
public static String Usrname = null;
public static String password = null;

	
public static void main(String[] args) throws IOException {
	
	WebDriverManager.chromedriver().setup();

	 driver= new ChromeDriver();
	 
	 ExcelLib lib = new ExcelLib();

	 siteurl = lib.readexcelData(0, 1);
	 
		driver.get(siteurl);
		
		driver.manage().window().maximize();
		 
		driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
		 
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 
		 String handle= driver.getWindowHandle();
		 System.out.println(handle);
		 Set handles = driver.getWindowHandles();
		 System.out.println(handles);
		 for (String handle1 : driver.getWindowHandles()) {
		     System.out.println(handle1);
		     driver.switchTo().window(handle1);
		 }
		 
		driver.manage().window().maximize();
			
		Usrname = lib.readexcelData(1,1);
		
		password = lib.readexcelData(2,1);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Usrname);

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);

		driver.findElement(By.xpath("//a[@class='loginButton']")).click();
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 WebElement ContactLnk = driver.findElement(By.xpath("//span/a[contains(text(),'Contracts')]"));
		
		ContactLnk.click();
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		 driver.switchTo().frame(0);
		
		WebElement ContractSrch = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[2]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/input[1]"));
		
		 ContractSrch.sendKeys("00135157");
	
		WebDriverWait wait = new WebDriverWait(driver, 15);

		WebElement Srchbtn = driver.findElement(By.xpath("(//td[contains(text(),'Search')])[1]"));
		Srchbtn.click();
		
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	//	 driver.findElement(By.xpath("//table//td[contains(text(),'No')]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		 
		       		
	       WebElement Contracttype = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.offerType']"));
	        
	        System.out.println(Contracttype.getText());
		
	        WebElement ContrctSubType = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.offerSubType']"));
	        
	        System.out.println(ContrctSubType.getText());
	        
	        WebElement Domain = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.contractDomain']"));

	       String DomainText = Domain.getText();
	        System.out.println(DomainText);
	        
	      lib.WriteExcelData(DomainText, 2, 3);
	        
	        WebElement Organization = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.organization']"));

	        System.out.println(Organization.getText());
	        
		      lib.WriteExcelData(Organization.getText(), 3, 3);

	        WebElement DistnMethod = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.directIndirectTypeValue']"));

	        System.out.println(DistnMethod.getText());
	        
	        WebElement RbPrgm = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.progOnly']"));
	        if (RbPrgm.getText().equals("Yes"))
	        System.out.println("checked");
	        else
		        System.out.println("unchecked");
	        
	        WebElement CstmID = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.customerId.textField']"));
	        
	        System.out.println(CstmID.getText());

	       
	        WebElement CntrctTermStratDate = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.contractStartDate']"));
	        
	        System.out.println(CntrctTermStratDate.getText());
	        

	        WebElement CntrctTermEndDate = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.contractEndDate']"));
	        
	        System.out.println(CntrctTermEndDate.getText());

	        WebElement RxNormMthd = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.rxNormMethod']"));
	        
	        System.out.println(RxNormMthd.getText());

	        WebElement CalcMethod = driver.findElement(By.xpath("//span[@comppath='root.main.bodyComp.documentFrame.contracts.offer.general.estimatedPmtBase']"));
	        
	        System.out.println(CalcMethod.getText());
	        
	        driver.close();
}		
}
