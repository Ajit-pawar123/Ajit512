package TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;

public class HomePage extends BaseClass{
	@Test(priority=2)
	public void validateHomepage()
	{
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertTrue(ActualTitle.equals("OrangeHRM"));
		
		String ActualUrl=driver.getCurrentUrl();
		Assert.assertTrue(ActualUrl.contains("orange"));
		System.out.println(ActualUrl);
	}
	
	

}
