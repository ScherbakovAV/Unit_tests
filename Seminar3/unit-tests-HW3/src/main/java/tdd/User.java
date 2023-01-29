package tdd;

public class User {
    String login;
    String password;
    Boolean adminRights;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.adminRights = false;
    }

    public boolean authMethod(String userLogin, String userPassword) {
        if (login.equals(userLogin) && password.equals(userPassword)) {
            return true;
        }
        else return false;
    }
}
