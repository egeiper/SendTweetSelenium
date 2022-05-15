package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private static String dateOfTweet;

    protected static void initializeDate(){
        Date date=new Date();
        DateFormat dateFormat=new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");
        dateOfTweet = dateFormat.format(date);
    }
    protected void getScreenshotOfTweet(WebElement context) throws IOException {
        File ss=context.getScreenshotAs(OutputType.FILE);
        String s=String.format("%s.png",dateOfTweet);
        FileUtils.copyFile(ss,new File(System.getProperty("user.dir")+"/src/main/resources/screenshots/"+s));
    }
}
