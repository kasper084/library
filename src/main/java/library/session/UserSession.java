package library.session;

import library.entity.User;

public final class UserSession {

    private static UserSession instance;

    private User loggedUser;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public void setLoggedUser(User user) {
        this.loggedUser = user;
    }

    public User getUser() {
        return loggedUser;
    }
}
