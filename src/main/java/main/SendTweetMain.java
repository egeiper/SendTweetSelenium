package main;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyManager;
import utils.driver.Driver;
import java.io.IOException;
import java.util.Scanner;

public class SendTweetMain extends Driver {

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException {
        Scanner sc=new Scanner(System.in);
        startDriver();
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
        loginPage.navigateToLoginPage(PropertyManager.getProps().getProperty("url"));
        System.out.println("Type login mail/username");
        String credential= sc.nextLine();
        loginPage.userNameCheck(credential);
        if(!loginPage.checkIfUsername(credential)) {
            System.out.println("Please type username for extra verification");
            loginPage.verifyUsername(sc.nextLine());
        }
        System.out.println("Type password");
        loginPage.passwordCheck(sc.nextLine());
        System.out.println("Type the tweet");
        homePage.sendTweet(sc.nextLine());
        quitDriver();
    }
}
