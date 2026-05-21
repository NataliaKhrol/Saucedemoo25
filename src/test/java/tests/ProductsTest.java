package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList =
            List.of("Test.allTheThings() T-Shirt (Red)",
                    "Sauce Labs Onesie",
                    "Sauce Labs Fleece Jacket");

    @Test(priority = 1, enabled = true)
    public void checkGoodsAdded() throws InterruptedException {
        System.out.println("Login4 running in thread: " + Thread.currentThread().getId());

        loginPage
                .open()
                .login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);

        productsPage.addToCart();
       /* productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");*/

        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }

        assertEquals(productsPage.checkCounterValue(), 4);
        Thread.sleep(5000);
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
