package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static user.UserFactory.withAdminPermission;


public class CartTest extends BaseTest {
    final String goodsName = "Test.allTheThings() T-Shirt (Red)";
    final String lastName = "Фамилия";

    @Test(alwaysRun = false, invocationCount = 1)
    public void checkGoodsInCart() {
        System.out.println("Login3 running in thread: " + Thread.currentThread().getId());

        SoftAssert soft = new SoftAssert();

        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.navigationPanel.switchToCart();

        soft.assertEquals(cartPage.getProductsNames().size(), 1);
        soft.assertFalse(cartPage.getProductsNames().isEmpty());
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));
        soft.assertTrue(cartPage.getProductsNames().contains(goodsName));

        //ОБЯЗАТЕЛЬНО!!!!!
        soft.assertAll();
    }
}
