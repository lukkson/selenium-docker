package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signLink;

    @FindBy(linkText = "Flights")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver webDriver){
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 30);
        PageFactory.initElements(webDriver, this);
    }

    public void proceedToFlightDetailsPage(){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.signLink));
        this.flightLink.click();
    }
}
