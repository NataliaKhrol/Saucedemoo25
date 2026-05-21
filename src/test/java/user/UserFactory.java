package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.locked_user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.incorrect_user"),
                PropertyReader.getProperty("saucedemoo.password"));
    }

    public static User withEmptyPassPermission() {
        return new User(
                PropertyReader.getProperty("saucedemoo.incorrect_user"),
                PropertyReader.getProperty(""));
    }
}
