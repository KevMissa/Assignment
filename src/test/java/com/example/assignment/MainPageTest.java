package com.example.assignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    String existingMail = "makekib509@vpsrec.com";
    String dummypassword = "dummy";

    String dummymail = "";

    public String generateRandomMail(){
            String generatedString = RandomStringUtils.randomAlphabetic(12);
            return generatedString+"@gmail.com";
        }


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void createAccount() throws InterruptedException {

        // Navigating to the sign up page
        mainPage.signInButton.click();

        // Writing the email I want to sign up with and submitting it

        dummymail = generateRandomMail();
        mainPage.inputEmail.sendKeys(dummymail);
        mainPage.buttonCreateAccount.click();


        // Filling all the information
        mainPage.rbGenderMr.click();
        mainPage.inputFirstName.sendKeys("Kevin");
        mainPage.inputLastName.sendKeys("Ibarra");
        mainPage.inputPassword.sendKeys(dummypassword);

        new Actions(driver).moveToElement(mainPage.listDays).perform();
        mainPage.listDays.click();
        Select selectDay = new Select(mainPage.listDays);
        selectDay.selectByIndex(19);

        new Actions(driver).moveToElement(mainPage.listMonths).perform();
        mainPage.listMonths.click();
        Select selectMonth = new Select(mainPage.listMonths);
        selectMonth.selectByIndex(1);

        new Actions(driver).moveToElement(mainPage.listYears).perform();
        mainPage.listYears.click();
        Select selectYear = new Select(mainPage.listYears);
        selectYear.selectByValue("1998");


        mainPage.inputAddress1.sendKeys("1210 Marshall St.");
        mainPage.inputCity.sendKeys("Manitowoc");
        mainPage.inputCompany.sendKeys("Google");
        Select selectState = new Select(mainPage.listState);
        selectState.selectByIndex(49);
        mainPage.inputPostcode.sendKeys("54220");
        mainPage.inputPhone.sendKeys("8127617703");
        Thread.sleep(4000);

        // Clicking on register
        mainPage.buttonRegister.click();
        Thread.sleep(10000);

        // Verifying that the sign up process was succesful and that I am in my account page
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("My account - My Store", title);
    }

    @Test
    public void login() throws InterruptedException {
        // navigating to login page
        mainPage.signInButton.click();
        // filling in login form
        mainPage.inputLoginEmail.sendKeys(existingMail);
        mainPage.inputLoginPassword.sendKeys(dummypassword);
        mainPage.buttonLogin.click();
        // Verifying I am in my account page, hence the login was successful
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("My account - My Store", title);
        Thread.sleep(5000);
    }



    @Test
    public void checkOutOneItem() throws InterruptedException {
        // login to have address information
        login();
        // navigating to women products
        mainPage.buttonWomen.click();
        // adding the first item to the cart
        new Actions(driver).moveToElement(mainPage.firstProduct).perform();
        mainPage.buttonATCfirstProduct.click();
        // navigating to checkout page
        mainPage.buttonCheckout.click();
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("Order - My Store", title);

        // Checkout process
        new Actions(driver).moveToElement(mainPage.buttonProceedToCheckout).perform();
        mainPage.buttonProceedToCheckout.click();

        new Actions(driver).moveToElement(mainPage.buttonProceedToCheckout2).perform();
        mainPage.buttonProceedToCheckout2.click();

        mainPage.checkBoxTerms.click();
        mainPage.buttonCheckoutCarrier.click();

        mainPage.buttonPaymentWire.click();
        mainPage.buttonConfirmPayment.click();

        // confirm the order is placed

        String orderConfirmation = mainPage.textConfirmation.getText();

        assertEquals("Your order on My Store is complete.", orderConfirmation);

    }

    @Test
    public void checkoutThreeItems() throws InterruptedException {
        // login to have address information
        login();
        // navigating to women products
        mainPage.buttonWomen.click();
        // adding the first item to the cart
        new Actions(driver).moveToElement(mainPage.firstProduct).perform();
        mainPage.buttonATCfirstProduct.click();
        mainPage.buttonCloseWindow.click();

        // adding the second item to the cart

        new Actions(driver).moveToElement(mainPage.productNameBlouse).perform();
        mainPage.buttonATCBlouse.click();
        mainPage.buttonCloseWindow.click();

        // adding the third item to the cart

        new Actions(driver).moveToElement(mainPage.thirdProduct).perform();
        mainPage.buttonATCthirdProduct.click();

        // navigating to checkout page

        mainPage.buttonCheckout.click();
        Thread.sleep(5000);
        String title = driver.getTitle();
        System.out.println(title);
        assertEquals("Order - My Store", title);

        // checkout process
        new Actions(driver).moveToElement(mainPage.buttonProceedToCheckout).perform();
        mainPage.buttonProceedToCheckout.click();

        new Actions(driver).moveToElement(mainPage.buttonProceedToCheckout2).perform();
        mainPage.buttonProceedToCheckout2.click();

        mainPage.checkBoxTerms.click();
        mainPage.buttonCheckoutCarrier.click();

        mainPage.buttonPaymentWire.click();
        mainPage.buttonConfirmPayment.click();

        // confirm the order is placed
        String orderConfirmation = mainPage.textConfirmation.getText();

        assertEquals("Your order on My Store is complete.", orderConfirmation);

        Thread.sleep(5000);
    }

    @Test
    public void ViewDetails() throws InterruptedException{
        mainPage.buttonWomen.click();
        new Actions(driver).moveToElement(mainPage.productNameBlouse).perform();
        mainPage.buttonQuickViewBlouse.click();
        assertEquals("Blouse", mainPage.productModalName.getText());
    }


    @Test
    public void signOut() throws InterruptedException {
        // login to the page
        login();

        // clicking sign out button
        mainPage.signOutButton.click();

        // Verifying the authentication text from login / sign up page is displayed
        assertTrue(mainPage.textAuthentication.isDisplayed());

        // Verifying I am signed out and back to the login / sign up page
        String title = driver.getTitle();
        assertEquals("Login - My Store", title);

    }



}
