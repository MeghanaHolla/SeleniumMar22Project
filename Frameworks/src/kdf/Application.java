package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application {
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelFeb22\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				Methods.openBrowser();
				break;
			case "maxBrowser":
				Methods.maximizeBrowser();
				break;
			case "impWait":
				Methods.implicitWait();
				break;
			case "navigateToApp":
				Methods.navigateToAUT(data[i][6]);
				break;
			case "enterUserID":
				Methods.enteruserID(data[i][4],data[i][5], data[i][6]);
				break;
			case "enterPassword":
				Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
				break;
			case "clickButton":
				Methods.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = Methods.getErrorMessage(data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(actualMsg, expectedMsg);
				break;
			case "closeAUT":
				Methods.closeApplication();
				break;
			}
		}
		
	}

}
