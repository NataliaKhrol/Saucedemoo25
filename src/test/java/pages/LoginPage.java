package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("[id='user-name']");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("[data-test='login-button']");
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта")
    public LoginPage open() {
        driver.get(BasePage.BASE_URL);

        return this;
    }

    public void open(final String url) {
        driver.get(BasePage.BASE_URL + url);
    }

    @Step("Логинимся под кредами пользователя")
    public LoginPage login(User user) {
        fillInLoginField(user.getLogin());
        fillInPassField(user.getPassword());
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Заполняем поле логин {login}")
    public void fillInLoginField(String login) {
        driver.findElement(userField).sendKeys(login);
    }

    @Step("Заполняем поле ввода пароля")
    public void fillInPassField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Проверяем, отображение сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    @Step("Берем текст из сообщения об ошибке")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
