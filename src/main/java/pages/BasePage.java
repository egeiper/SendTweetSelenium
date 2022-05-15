package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.Driver;

public class BasePage extends Driver{

   protected WebDriverWait wait=new WebDriverWait(getDriver(),10);

    public BasePage(){
        PageFactory.initElements(getDriver(),this);
    }

    public  void clickElement(WebElement element){
        waitForElement(element).click();
    }
    public  WebElement waitForElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }





}
