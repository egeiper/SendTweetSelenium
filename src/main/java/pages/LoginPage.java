package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Scanner;

public class LoginPage extends BasePage {

    Scanner sc=new Scanner(System.in);

    @FindBy(css = "input[type='text']")
    public  WebElement textBox;

    @FindBy(xpath = "//div[@role='button'][2]")
    public  WebElement nextButton;

    @FindBy(css = "input[type='password']")
    public  WebElement passwordTextBox;

    @FindBy(css = "[data-testid=\"ocfEnterTextNextButton\"]")
    public  WebElement verifyNextButton;

    @FindBy(css = "[data-testid=\"LoginForm_Login_Button\"]")
    public  WebElement loginButton;


    public void userNameCheck(String username) {
        By usernameNextButton=By.cssSelector("[data-testid=\"ocfSettingsListPrimaryText\"]");
        textBox.sendKeys(username);
        clickElement(nextButton);
        while (getDriver().findElements(usernameNextButton).size() != 0) { // if we couldn't skip the page which means button still appears on the page.
            System.out.println("Wrong username/mail ! Please type again.");
            username = sc.nextLine();
            textBox.clear();
            textBox.sendKeys(username);
            clickElement(nextButton);
        }
    }

    public void passwordCheck(String password) {
        By loginFormButton=By.cssSelector("[data-testid=\"LoginForm_Login_Button\"]");
        passwordTextBox.sendKeys(password);
        clickElement(loginButton);
        while (getDriver().findElements(loginFormButton).size() != 0) { // if we couldn't skip the page which means button still appears on the page.
            System.out.println("Wrong password ! Please type again.");
            password = sc.nextLine();
            passwordTextBox.clear();
            passwordTextBox.sendKeys(password);
            clickElement(loginButton);
        }
    }
    public void verifyUsername(String username){
        By verifyButton=By.cssSelector("[data-testid=\"ocfEnterTextNextButton\"]");
        textBox.sendKeys(username);
        clickElement(verifyNextButton);
        while (getDriver().findElements(verifyButton).size() != 0) { // if we couldn't skip the page which means button still appears on the page.
            System.out.println("Wrong username! Please type again.");
            username = sc.nextLine();
            textBox.clear();
            textBox.sendKeys(username);
            clickElement(verifyNextButton);
        }
    }
    public  void navigateToLoginPage(String url){
        getDriver().get(url);
        System.out.println("Please wait url to be loaded...");
        wait.until(ExpectedConditions.visibilityOf(textBox)); // wait until frame to be loaded, checks the title in frame.
    }
    public  boolean checkIfUsername(String credential){
        return !credential.contains(".com") && !credential.contains("@");
    }

}
