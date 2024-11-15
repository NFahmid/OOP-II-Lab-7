package services;

import utils.CSVUtils;

public class UserManager {
    private static String USER_FILE = "User.csv";
    private static String ADMIN_FILE = "Admin.csv";

    private static UserManager instance;

    private UserManager() {}

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void readUsers() {
        System.out.println("User List:");
        CSVUtils.readCSV(USER_FILE).forEach(row -> System.out.println(String.join(", ", row)));
    }

    public void addUser(String username, String email, String password) {
        if (CSVUtils.isDuplicate(USER_FILE, username, email)) {
            System.out.println("Error: Username or email already exists!");
            return;
        }
        CSVUtils.appendToCSV(USER_FILE, new String[] {username, email, password});
        System.out.println("User added successfully: " + username);
    }

    public void updateUser(String username, String email, String password) {
        boolean updated = CSVUtils.updateCSV(USER_FILE, username, new String[] {username, email, password});
        if (updated) {
            System.out.println("User updated successfully: " + username);
        } else {
            System.out.println("Error: User not found!");
        }
    }

    public void renameFile(String oldName, String newName) {
        boolean success = CSVUtils.renameFile( oldName,  newName);
        if (success) {
            System.out.println("File renamed successfully: " + newName);
            USER_FILE = newName;
        } else {
            System.out.println("Error: File rename failed!");
        }
    }
}
