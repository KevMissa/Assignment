package com.example.assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {


    // NAVBAR
    @FindBy(xpath = "//a[@class='login']")
    public WebElement signInButton;
    @FindBy(xpath = "(//*[text()[contains(.,'Sign out')]])[1]")
    public WebElement signOutButton;



    // Login / sign up page

    @FindBy(xpath = " //h1[contains(text(),'Authentication')]")
    public WebElement textAuthentication;
    @FindBy(id = "email")
    public WebElement inputLoginEmail;

    @FindBy(id = "passwd")
    public WebElement inputLoginPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement buttonLogin;

    @FindBy(id = "SubmitCreate")
    public WebElement buttonCreateAccount;

    @FindBy(xpath = "//a[@title='Women']")
    public WebElement buttonWomen;



    // Page women


    // Aqui hice un xpath para que me trajera el primer producto, y su boton de agregar a carrito
    @FindBy(xpath = "(//div[@class='product-container'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//div[@class='product-container'])[1]//div[@class='button-container']/a[@title='Add to cart']")
    public WebElement buttonATCfirstProduct;

    // producto basado en nombre, en este caso Blouse
    @FindBy(xpath = "//a[contains(text(),'Blouse')]//ancestor::div[@class='product-container']")
    public WebElement productNameBlouse;

    @FindBy(xpath = "//a[contains(text(),'Blouse')]//ancestor::div[@class='product-container']//div[@class='button-container']/a[@title='Add to cart']")
    public WebElement buttonATCBlouse;

    @FindBy(xpath = " //a[contains(text(),'Blouse')]//ancestor::div[@class='product-container']//a[@class='quick-view']")
    public WebElement buttonQuickViewBlouse;



    // tercer producto

    @FindBy(xpath = "(//div[@class='product-container'])[3]")
    public WebElement thirdProduct;

    @FindBy(xpath = "(//div[@class='product-container'])[3]//div[@class='button-container']/a[@title='Add to cart']")
    public WebElement buttonATCthirdProduct;


    //  Product added modal
    @FindBy(xpath = "//span[@title='Close window']")
    public WebElement buttonCloseWindow;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement buttonCheckout;


    // Details modal
    @FindBy(id = "product")
    public WebElement productModal;

    @FindBy(xpath = "//h1[@itemprop=\"name\"]")
    public WebElement productModalName;




    // CREATE ACCOUNT PAGE

    @FindBy(id = "email_create")
    public WebElement inputEmail;

    @FindBy(id = "id_gender1")
    public WebElement rbGenderMr;

    @FindBy(id = "id_gender2")
    public WebElement rbGenderMs;

    @FindBy(id = "customer_firstname")
    public WebElement inputFirstName;

    @FindBy(id = "customer_lastname")
    public WebElement inputLastName;

    @FindBy(id = "passwd")
    public WebElement inputPassword;

    @FindBy(id = "days")
    public WebElement listDays;

    @FindBy(id = "months")
    public WebElement listMonths;

    @FindBy(id = "years")
    public WebElement listYears;

    @FindBy(id = "firstname")
    public WebElement inputAddressFirstName;

    @FindBy(id = "lastname")
    public WebElement inputAddressLastName;

    @FindBy(id = "company")
    public WebElement inputCompany;

    @FindBy(id = "address1")
    public WebElement inputAddress1;

    @FindBy(id = "city")
    public WebElement inputCity;

    @FindBy(id = "id_state")
    public WebElement listState;

    @FindBy(id = "postcode")
    public WebElement inputPostcode;

    @FindBy(id = "id_country")
    public WebElement listCountry;

    @FindBy(id = "phone")
    public WebElement inputPhone;

    @FindBy(id = "submitAccount")
    public WebElement buttonRegister;



    // Pagina Checkout

    @FindBy(xpath = "//p/a[@title='Proceed to checkout']\n")
    public WebElement buttonProceedToCheckout;

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]/parent::button")
    public WebElement buttonProceedToCheckout2;


    @FindBy(xpath = "//button[@name='processCarrier']")
    public WebElement buttonCheckoutCarrier;


    @FindBy(xpath = "//input[@id='cgv']")
    public WebElement checkBoxTerms;

    @FindBy(xpath = "//a[@title='Pay by bank wire']")
    public WebElement buttonPaymentWire;


    @FindBy(xpath = "//span[contains(text(),'I confirm my order')]/parent::button\n")
    public WebElement buttonConfirmPayment;

    @FindBy(xpath = " //p[@class='cheque-indent']/strong")
    public WebElement textConfirmation;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
