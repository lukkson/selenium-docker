package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement textBox;

    @FindBy(id="search_button_homepage")
    private WebElement searchButton;

    @FindBy(linkText = "Wideo")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> videoList;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword) {
        this.wait.until(ExpectedConditions.visibilityOf(textBox));
        this.textBox.sendKeys(keyword);
        this.searchButton.click();
    }

    public void goToVidos(){
        this.wait.until(ExpectedConditions.visibilityOf(videosLink));
        this.videosLink.click();
    }

    public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        int size = this.videoList.size();
        return size;
    }
}
