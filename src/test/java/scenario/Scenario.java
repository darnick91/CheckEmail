package scenario;

import browser.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import user.User;

public class Scenario extends Controller {

    private static final String UKR_NET_LOGIN = "https://accounts.ukr.net/login";
    private static final User TEST_USER_1 = new User("testmailepam@ukr.net", "Qwerty1213", "Mail for test");
    private static final User TEST_USER_2 = new User("testmailepam2@ukr.net", "Qwerty1213", "Massage are received");

    @Test
    public void sendMail(){
        getDriver().get(UKR_NET_LOGIN);

        getUkrNetMail()
                .inputMailAddress(TEST_USER_1.getMail())
                .inputPassword(TEST_USER_1.getPassword())
                .writeMailButtonClick()
                .writeMail(TEST_USER_2.getMail(), TEST_USER_1.getMailText());

        Assertions.assertTrue(getUkrNetMail().checkMassageReceived());
    }
}
