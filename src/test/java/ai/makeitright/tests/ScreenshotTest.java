package ai.makeitright.tests;

import ai.makeitright.utilities.DriverConfig;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest extends DriverConfig {

    private final String screenshotsPath = System.getProperty("SCREENSHOTS_PATH");
    private final String fileSeparator = System.getProperty("file.separator");
    private final String url = System.getProperty("inputParameters.url");


    @Test
    public void takeScreenshot() throws IOException {
        driver.manage().window().maximize();
        driver.get(url);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File before = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(before, new File(screenshotsPath + fileSeparator + "screenshot.png"));
        JSONObject outputObject = new JSONObject();
        outputObject.put("url", url);
        System.setProperty("output", outputObject.toString());
//        System.out.print(System.getProperty("output"));
    }

}
