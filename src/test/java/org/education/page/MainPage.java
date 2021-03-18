package org.education.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends AbstractPage{
    private final String BASE_URL = "https://pastebin.com/";

    @FindBy(xpath = "//a[@class='header__btn']")
    private WebElement pasteBtn;

    @FindBy(id = "postform-text")
    private WebElement inputCommand;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingElement;

   @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpirationElement;

    @FindBy(id = "postform-name")
    private WebElement inputPasteName;

    @FindBy(xpath = "//div[@class='post-form__left']/div[@class='form-group form-btn-container']/button")
    private WebElement createPasteBtn;

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public MainPage clickNewPasteBtn(){
        pasteBtn.click();
        return this;
    }

    public MainPage inputTextArea(String text) {
        inputCommand.sendKeys(text);
        return this;
    }

    public MainPage selectPasteExpirationFromDropDownList(String option){
        pasteExpirationElement.click();
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@role='listbox']/li"));
        webElements.removeIf(webElement -> !(webElement.getText().equals(option)));
        webElements.get(0).click();
        return this;
    }

    public MainPage selectPastSyntaxHighlightingFromDropDownList(String option) {
        syntaxHighlightingElement.click();
        List<WebElement> webElements = driver.findElements(By.xpath("//*[@role='listbox']/li/ul/li"));
        webElements.removeIf(webElement -> !(webElement.getText().equals(option)));
        webElements.get(0).click();
        return this;
    }

    public MainPage inputTitle(String text) {
        inputPasteName.sendKeys(text);
        return this;
    }

    public MainPage clickCreateNewPasteBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-postform-expiration-container")));
        createPasteBtn.click();
        return this;
    }

    //    public MainPage createNewPastebinElement() {
//        pasteBtn.click();
//
//        inputCode.sendKeys("Hello from WebDriver");
//
//        findPasteExpiration.click();
//        List<WebElement> element = driver.findElements(By.xpath("//*[@role='listbox']/li"));
//        element.get(2).click();
//
//        inputPasteName.sendKeys("helloweb");
//
//        createPasteBtn.click();
//
//        return this;
//    }
}
