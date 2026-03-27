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
}
