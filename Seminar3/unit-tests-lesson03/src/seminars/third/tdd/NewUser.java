package seminars.third.tdd;

public class NewUser {
    String login;
    String password;

    public NewUser(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public boolean authMethod(String userLogin, String userPassword) {
        if (login.equals(userLogin) && password.equals(userPassword)) {
            return true;
        }
        else return false;
    }
}
