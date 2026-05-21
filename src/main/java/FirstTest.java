import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FirstTest {
    //КРАТНО 3, ВОЗВРАЩАТЬ 'T'
    //КРАТНО 5, ВОЗВРАЩАТЬ 'M'
    //КРАТНО 3 И 5, ВОЗВРАЩАТЬ 'TSM'
    //ВОЗВРАЩАТЬ 'FAIL'

    public String trialCode(int number) {
        if (number % 3 == 0 && number % 5 == 0) {
            return "TSM";
        } else if (number % 5 == 0) {
            return "M";
        } else if (number % 3 == 0) {
            return "T";
        } else return "FAIL";
    }

    @Test
    public void checkTrialNumber() {
        String actualResult = trialCode(9);
        assertEquals(actualResult, "T");
    }

    @Test
    public void checkTrialNumber2() {
        String actualResult = trialCode(25);
        assertEquals(actualResult, "M");
    }

    @Test
    public void checkTrialNumber3() {
        String actualResult = trialCode(15);
        assertEquals(actualResult, "TSyyM");
    }

    @Test
    public void checkTrialNumber43() {
        String actualResult = trialCode(7);
        assertEquals(actualResult, "FAIL");
    }
/*
    @Test
    public void checkAlert() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        System.out.println(text);
        alert.accept();
    }

    @Test
    public void checkFrame() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        String frameText = driver.findElement(By.tagName("p")).getText();
        assertEquals(frameText, "Your content goes here.");
        driver.switchTo().defaultContent();
    }*/
}
