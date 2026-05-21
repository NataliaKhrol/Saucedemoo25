package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;
import static user.UserFactory.*;

/**
 * Данный тест класс....
 */

@Epic("Онлайн оплата")
@Feature("Оплата банковской картой")
@Owner("Иванов Иван Ivanov@bla.com")
public class LoginTest extends BaseTest {
    @Story("Ввод данных карты")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Saucedemoo25")
    @Issue("BBS")
    @Test(description = "Проверка корректный логин", dependsOnMethods = "checkIncorrectLogin",
            priority = 1)
    public void checkLogin() throws InterruptedException {
        System.out.println("Login1 running in thread: " + Thread.currentThread().getId());

        loginPage
                .open()
                .open()
                .open()
                .open()
                .open()
                .login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());

        Thread.sleep(2000);
    }


    @Story("Ввод данных карты")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Saucedemoo25")
    @Test(dataProvider = "incorrectData", priority = 2)
    public void checkIncorrectLogin(User user, String errorMessage) {
        System.out.println("Login2 running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage,
                "Error message doesn't correspond");
    }

    @DataProvider(name = "incorrectData")
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                /* {"", "secret_sauce", "Epic sadface: Username is required"},
                 {"standard_user", "", "Epic sadface: Password is required"},*/
                {withIncorrectPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
