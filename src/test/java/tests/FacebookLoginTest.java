package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FacebookLoginPage;

public class FacebookLoginTest {

    private WebDriver driver;
    private FacebookLoginPage loginPage;

    @BeforeEach
    public void setUp() {
        // Set the path to your chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        loginPage = new FacebookLoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLogin() {
        loginPage.setEmail("your-email@domain.com");
        loginPage.setPassword("your-password");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that you have successfully logged in
    }

    @Test
    public void testValidCredentials() {
        loginPage.setEmail("valid-email@domain.com");
        loginPage.setPassword("valid-password");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that you have successfully logged in
    }

    @Test
    public void testLongCredentials() {
        loginPage.setEmail("thisisaverylongemailaddress@domain.com");
        loginPage.setPassword("thisisaverylongpassword1234");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that you have successfully logged in
    }

    @Test
    public void testWhitespaceInCredentials() {
        loginPage.setEmail(" email-with-whitespace@domain.com ");
        loginPage.setPassword(" password-with-whitespace ");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that you have successfully logged in
    }

    @Test
    public void testInvalidEmail() {
        loginPage.setEmail("invalid-email");
        loginPage.setPassword("valid-password");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that the login failed
    }

    @Test
    public void testEmptyCredentials() {
        loginPage.setEmail("");
        loginPage.setPassword("");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that the login failed
    }

    @Test
    public void testWrongPassword() {
        loginPage.setEmail("valid-email@domain.com");
        loginPage.setPassword("wrong-password");
        loginPage.clickLoginButton();
        // Add your assertions here to verify that the login failed
    }

}

