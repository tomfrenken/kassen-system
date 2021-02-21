package kassenSystem.test;

import kassenSystem.model.AdminLogin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AdminTest {
    AdminLogin defaultAdminLogin = new AdminLogin();

    @Test
    public void checkPassword() throws Exception {
        Throwable exceptionForWrongPassword = assertThrows(Exception.class, () -> defaultAdminLogin.checkPassword("ABC"));

        assertTrue(defaultAdminLogin.checkPassword("123456"));
        assertEquals("Password ist nicht korrekt", exceptionForWrongPassword.getMessage());
    }

    @Test
    public void getIsLoggedIn() {
        assertFalse(defaultAdminLogin.getIsLoggedIn());
    }

    @Test
    public void logOut(){
        defaultAdminLogin.logOut();
        assertFalse(defaultAdminLogin.getIsLoggedIn());
    }

    @Test
    public void AdminLogin() throws Exception {
        AdminLogin testLogin = new AdminLogin("i love bordihn");
        assertTrue(testLogin.checkPassword("i love bordihn"));
    }
}
