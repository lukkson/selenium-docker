package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(name="firstName")
    private WebElement firstNameField;

    @FindBy(name="lastName")
    private WebElement lastNameField;

    @FindBy(name="email")
    private WebElement userNameField;

    @FindBy(name="password")
    private WebElement passwordField;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(name="register")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.firstNameField));
    }

    public void enterUserDetails(String firstName, String lastName) {
        this.firstNameField.sendKeys(firstName);
        this.lastNameField.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName, String password) {
        this.userNameField.sendKeys(userName);
        this.passwordField.sendKeys(password);
        this.confirmPasswordField.sendKeys(password);
    }

    public void submit() {
        this.submitButton.click();
    }
}
