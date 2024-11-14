import java.util.ArrayList;
import java.util.List;

public class UserManagementSystem {
    private static UserManagementSystem instance;
    private List<User> users;

    private UserManagementSystem() {
        users = new ArrayList<>();
        loadUsers();
    }

    public static UserManagementSystem getInstance() {
        if (instance == null) {
            instance = new UserManagementSystem();
        }
        return instance;
    }

    private void loadUsers() {
    }

    public User authenticate(String username, String password) {
        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }
}
