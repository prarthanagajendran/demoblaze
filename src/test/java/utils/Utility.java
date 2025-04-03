package utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class Utility {
	public static WebDriver wait;
	public static WebDriver driver;
	public static Properties prop;
	public String sheetname;
	public String filepath;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName, testDescription, testCategory, testAuthor;

	public static void launchingBrowser(String url, String browser)  {
try {
 		driver = new ChromeDriver();
//https://www.demoblaze.com/
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(1000);
}catch(Exception e){
    System.err.println("❌ Error during browser launch: " + e.getMessage());

	
}
	}

	public static void closingbrowser() {

		driver.close();
	}

	public static void hardAssertCheck(String acc, String exp) {

		Assert.assertEquals(acc, exp);
	}

	public static String[][] readExcel(String sheetname) throws Exception {

		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Pradeep\\eclipse-workspace\\demoblaze\\src\\test\\resources\\Demoblazetestdatanew.xlsx");
		XSSFSheet sheet = book.getSheet(sheetname);
 		int rowCount = sheet.getLastRowNum();
 		
 		System.out.println("Row count: "+rowCount);
 		int columnCount = sheet.getRow(0).getLastCellNum();
 		System.out.println("Column count: "+columnCount);
 	    DataFormatter dataFormatter = new DataFormatter();

 		String[][] data = new String[rowCount][columnCount];
 		for(int i =1 ; i <= rowCount; i++) {
 			XSSFRow row = sheet.getRow(i);
 			for(int j =0 ; j<columnCount; j++) {
 				XSSFCell cell = row.getCell(j);
 				data[i-1][j] = dataFormatter.formatCellValue(cell);       //cell.getStringCellValue();
 			}
 		}
         book.close();
 		return data;
	}

	public static void readFromPropFile(String filepath) throws IOException {

		FileReader file = new FileReader(filepath);
		prop = new Properties();
		prop.load(file);
	}

	public static String screenshot(String name) throws IOException {

		String path = "C:\\Users\\Pradeep\\eclipse-workspace\\demoblaze\\screenshots\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}
