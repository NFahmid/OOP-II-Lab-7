import models.*;

public class Main {
    public static void main(String[] args) {
        RegularUser regularUser = new RegularUser();
        PowerUser powerUser = new PowerUser();
        AdminUser adminUser = new AdminUser();

        regularUser.viewUsers();

        powerUser.viewUsers();
        powerUser.addUser("Nuren Fahmid", "nuren@gmail.com", "password123");

        adminUser.viewUsers();
        adminUser.addUser("admin1", "admin@example.com", "adminpass");
        adminUser.updateUser("Nuren Fahmid", "nurenfahmid@iut-dhaka.edu", "newpassword");
        adminUser.renameFile("User.csv", "UsersRenamed.csv");
    }
}
