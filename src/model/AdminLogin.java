package model;

/**
 *
 */
public class AdminLogin {
    /**
     * The attribute password is the password required for accessing the admin view.
     * The attribute isLoggedIn keeps track if there is an Admin currently logged in.
     */
    private String password = "123456";
    private boolean isLoggedIn = false;

    /**
     * Checks if the entered password is correct.
     * Throws an exception if a wrong password was entered.
     *
     * @throws Exception if the password was wrong
     */
    public boolean checkPassword(String password) throws Exception {
        if (this.password.contentEquals(password)) {
            isLoggedIn = true;
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
