package kassenSystem.model;

/**
 *
 */
public class AdminLogin {
    private final String password;
    private boolean isLoggedIn = false;

    /**
     * The AdminLogin is initiated with a default password of 123456.
     */
    AdminLogin(){
        this.password = "123456";
    }

    /**
     * The AdminLogin is initiated with a password.
     *
     * @param password The password for the AdminLogin
     */
    AdminLogin(String password){
        this.password = password;
    }

    /**
     * Checks if the entered password is correct.
     * Throws an exception if a wrong password was entered.
     *
     * @throws Exception if the password was wrong
     */
    public boolean checkPassword(String password) throws Exception {
        if (this.password.contentEquals(password)) {
            this.isLoggedIn = true;
            return true;
        } else {
            throw new Exception("Password ist nicht korrekt");
        }
    }

    /**
     * Sets the attribute isLoggedIn to false.
     */
    public void logOut() {
        isLoggedIn = false;
    }

    /**
     * Returns the current value of the attribute isLoggedIn.
     *
     * @return the current value of isLoggedIn
     */
    public boolean getIsLoggedIn() {
        return isLoggedIn;
    }
}
