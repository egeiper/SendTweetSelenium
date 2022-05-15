package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class HomePage extends BasePage{

    @FindBy(css = "[data-testid=\"SideNav_NewTweet_Button\"]")
    public static WebElement tweetButton;

    @FindBy(css = "[data-testid='tweetTextarea_0']")
    public static WebElement textArea;

    @FindBy(css = "[data-testid=\"tweetButton\"]")
    public static WebElement tweetButton2;

    @FindBy(xpath = "//*[@data-testid=\"cellInnerDiv\"][1]")
    public static WebElement tweetCell;

    @FindBy(xpath = "//*[@data-testid=\"cellInnerDiv\"][1]//*[@data-testid=\"tweetText\"]")
    public static WebElement textOfTweet;

    @FindBy(css = "[data-testid=\"AppTabBar_Profile_Link\"]")
    public static WebElement profileButton;

    public void sendTweet(String tweet) throws IOException {
        clickElement(tweetButton);
        textArea.sendKeys(tweet);
        clickElement(tweetButton2);
        clickElement(profileButton);
        if(textOfTweet.getText().equals(tweet)){
            System.out.println("Your tweet is sent successfully!");
            getScreenshotOfTweet(tweetCell);
        }

        else
            System.out.println("Tweet couldn't be sent");





    }
}
