package com.solvd.carinatestautomation.gui.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class CoffeeCartPage extends AbstractPage {

    @FindBy(css = "h4")
    private List<ExtendedWebElement> coffeeTitles;

    @FindBy(css = "[data-test='%s']")
    private ExtendedWebElement coffeeCup;

    @FindBy(css = "[data-test='checkout']")
    private ExtendedWebElement totalButton;

    @FindBy(css = "[aria-label='Cart page']")
    private ExtendedWebElement cartLink;

    @FindBy(id = "name")
    private ExtendedWebElement nameInput;

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "submit-payment")
    private ExtendedWebElement submitButton;

    @FindBy(css = ".snackbar.success")
    private ExtendedWebElement successMessage;

    public CoffeeCartPage(WebDriver driver) {
        super(driver);
    }

    public void selectCoffee(String coffeeName) {
        String formattedName = coffeeName.replace(" ", "_");
        coffeeCup.format(formattedName).click();
    }

    public String getTotalAmount() {
        return totalButton.getText();
    }

    public void clickTotal() {
        totalButton.click();
    }

    public CartPage openCartPage() {
        cartLink.click();
        return new CartPage(getDriver());
    }

    public boolean isCoffeePresent(String coffeeName) {
        for (ExtendedWebElement title : coffeeTitles) {
            if (title.getText().toLowerCase().contains(coffeeName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public List<ExtendedWebElement> getCoffeeTitles() {
        return coffeeTitles;
    }

    public void typeName(String name) {
        nameInput.type(name);
    }

    public void typeEmail(String email) {
        emailInput.type(email);
    }

    public void submitPayment() {
        submitButton.click();
    }

    public String getSuccessMessage() {
        if (successMessage.isElementPresent(5)) {
            return successMessage.getText();
        }
        return "";
    }
}
