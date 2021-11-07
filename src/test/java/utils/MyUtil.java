package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class MyUtil {
    private static Random random = new Random();
    private static final String CHAR_ABC = "abcdefghijklmnopqrstuvwxyz";//из этих символов будем формировать случайную строку

    public static String generateRandomString(int stringlenght) {
        StringBuilder stringBuilder = new StringBuilder(stringlenght);
        for (int i = 0; i < stringlenght; i++) {
            stringBuilder.append(CHAR_ABC.charAt(random.nextInt(CHAR_ABC.length())));//добавляем по одному случайному висволу
        }
        return stringBuilder.toString();
    }

    public static void HighlightElement(WebDriver driver, WebElement elm) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='4px groove red'", elm);
            Thread.sleep(1000);
            js.executeScript("arguments[0].style.border=''", elm);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void takeScreenshots(WebDriver driver){
        File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = "screenshots/scr"+System.nanoTime();
            String scrPath = screenshotName+".jpg";
            File copy=new File(scrPath);
            FileUtils.copyFile(screenshot,copy );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
