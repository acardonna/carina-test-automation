package com.solvd.carinatestautomation.gui.pages.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class CartPage extends AbstractPage {

    @FindBy(css = "ul.cart-list li")
    private List<ExtendedWebElement> cartItems;

    @FindBy(css = ".list")
    private ExtendedWebElement cartList;

    @FindBy(css = "[data-test='checkout']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(cartList);
        setPageURL("/cart");
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
