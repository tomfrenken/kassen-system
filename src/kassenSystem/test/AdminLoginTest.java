package kassenSystem.test;

import kassenSystem.model.AdminLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the AdminLogin.
 */
public class AdminLoginTest {

    AdminLogin defaultAdminLogin = new AdminLogin();

    /**
     * Test if the checkPassword function works correctly.
     * Throws Exception if the password is wrong.
     *
     * @throws Exception if the password is wrong
     */
    @Test
    public void checkPassword() throws Exception {
        Throwable exceptionForWrongPassword = assertThrows(Exception.class, () -> defaultAdminLogin.checkPassword("ABC"));

        assertTrue(defaultAdminLogin.checkPassword("123456"));
        assertEquals("Password ist nicht korrekt", exceptionForWrongPassword.getMessage());
    }

    /**
     * Test if the getIsLoggedIn function works correctly.
     */
    @Test
    public void getIsLoggedIn() {
        assertFalse(defaultAdminLogin.getIsLoggedIn());
    }

    /**
     * Test if the logOut function works correctly.
     */
    @Test
    public void logOut(){
        defaultAdminLogin.logOut();
        assertFalse(defaultAdminLogin.getIsLoggedIn());
    }

    /**
     * Test if the adminLogin function works correctly.
     * Throws Exception if the password is wrong.
     *
     * @throws Exception if the password was wrong
     */
    @Test
    public void AdminLogin() throws Exception {
        AdminLogin testLogin = new AdminLogin("i love bordihn");
        assertTrue(testLogin.checkPassword("i love bordihn"));
    }
}
