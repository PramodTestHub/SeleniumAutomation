package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

    public static void captureScreenshot() throws IOException {
    	WebDriver driver = DriverManager.getDriver();

        // Create directory if not exists
        File dir = new File("target/screenshots");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Define file path
        File dest = new File("target/screenshots/"+"pramod"+".png");

        // If file already exists, delete it
        if (dest.exists()) {
            dest.delete();
        }

        // Capture and save screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, dest);
        System.out.println("Screenshot saved: " + dest.getAbsolutePath());

    }
}
