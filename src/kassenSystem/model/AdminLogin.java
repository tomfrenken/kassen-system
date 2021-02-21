package kassenSystem.model;

/**
 * This Class handles the Admin password and LoggedIn Status
 */
public class AdminLogin {

    /**
     * This is the password for the admin account.
     * The attribute isLoggedIn keeps track if an Admin is logged in.
     */
    private final String password;
    private boolean isLoggedIn = false;

    /**
     * The AdminLogin is initiated with a default password of 123456.
     */
    public AdminLogin(){
        this.password = "123456";
    }

    /**
     * The AdminLogin is initiated with a password.
     *
     * @param password the password for the AdminLogin
     */
    public AdminLogin(String password){
        this.password = password;
    }

    /**
     * Checks if the entered password is correct.
     * Throws an exception if a wrong password was entered.
     *
     * @param  password the password that is being checked
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
