package TestLayer;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import UtilityLayer.ExcelReader;

public class PimPage extends BaseClass {
	@Test(priority = 3)
	public void validatePIMpage() {
		driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();

		driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-item'])[2]")).click();

	}

	@Test(priority = 4, dataProvider = "addEmployee")
	public void AddEmployee(String fname, String mname, String lname) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).sendKeys(fname);
		driver.findElement(By.name("middleName")).sendKeys(mname);
		driver.findElement(By.name("lastName")).sendKeys(lname);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[text()=' Save ']")).click();

	}

	@DataProvider()
	public Object[][] addEmployee() throws IOException {
		ExcelReader obj = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\OrangeHRMData.xlsx");

		Object[][] data = obj.getAllSheetData(0);
		return data;

	}

}
