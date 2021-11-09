package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyUtil {
    private static final Logger logger = Logger.getLogger(MyUtil.class);
    private static final Random random = new Random();
    private static final String CHAR_ABC = "abcdefghijklmnopqrstuvwxyz";//из этих символов будем формировать случайную строку

    public static String generateRandomString(int stringlenght) {
        StringBuilder stringBuilder = new StringBuilder(stringlenght);
        for (int i = 0; i < stringlenght; i++) {
            stringBuilder.append(CHAR_ABC.charAt(random.nextInt(CHAR_ABC.length())));//добавляем по одному случайному висволу
        }
        return stringBuilder.toString();
    }

    public static void highlightElement(WebDriver driver, WebElement elm) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='4px groove red'", elm);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border=''", elm);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static void takeScreenshots(WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            String scrPath = "screenshots/scr" + System.nanoTime() + ".png";
            File copy = new File(scrPath);
            FileUtils.copyFile(screenshot, copy);
            captureScreenshot(driver);
        } catch (IOException e) {
            logger.error("takeScreenshots method fail with massege ", e);
        }
    }
    @Attachment(value = "Screenshot", type = "image/png")
    private static byte[] captureScreenshot(WebDriver driver) {
        byte[] screenshot = null;
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}
