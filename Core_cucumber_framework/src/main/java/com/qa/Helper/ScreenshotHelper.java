package com.qa.Helper;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotHelper {
	
	public static String CaptureScreen(WebDriver driver, String imageName)
	{
	File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String encodedBase64 = null;
	FileInputStream fileInputStreamReader = null;
	try {
	fileInputStreamReader = new FileInputStream(sourceFile);
	byte[] bytes = new byte[(int)sourceFile.length()];
	fileInputStreamReader.read(bytes);
	encodedBase64 = new String(Base64.getEncoder().encode(bytes));

	        String screenShotDestination = System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + imageName + ".png";

	        File destination = new File(screenShotDestination);
	        FileUtils.copyFile(sourceFile, destination);
	        
	        Files.copy(sourceFile, destination);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "data:image/png;base64,"+encodedBase64;
	}



}
