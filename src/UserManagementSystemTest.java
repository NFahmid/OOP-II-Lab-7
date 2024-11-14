import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserManagementSystemTest {

    @Test
    void testAuthenticateRegularUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        User regularUser = new RegularUser("1", "user1", "user1@example.com", "password1");
        ums.addUser(regularUser);
        assertTrue(ums.authenticate("user1", "password1") instanceof RegularUser, "Expected instance of RegularUser.");
    }

    @Test
    void testAuthenticatePowerUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        User powerUser = new PowerUser("2", "user2", "user2@example.com", "password2");
        ums.addUser(powerUser);
        assertTrue(ums.authenticate("user2", "password2") instanceof PowerUser, "Expected instance of PowerUser.");
    }

    @Test
    void testAuthenticateAdminUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        User adminUser = new AdminUser("3", "admin", "admin@example.com", "adminpass");
        ums.addUser(adminUser);
        assertTrue(ums.authenticate("admin", "adminpass") instanceof AdminUser, "Expected instance of AdminUser.");
    }

    @Test
    void testAddUser() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        User newUser = new RegularUser("4", "newUser", "newUser@example.com", "newpass");
        ums.addUser(newUser);
        assertNotNull(ums.authenticate("newUser", "newpass"), "Expected user to be added and authenticated.");
    }

    @Test
    void testGetUserByUsername() {
        UserManagementSystem ums = UserManagementSystem.getInstance();
        User existingUser = new RegularUser("5", "existingUser", "existingUser@example.com", "existpass");
        ums.addUser(existingUser);
        User retrievedUser = ums.getUserByUsername("existingUser");
        assertNotNull(retrievedUser, "Expected to retrieve user by username.");
        assertEquals("existingUser", retrievedUser.getUsername(), "Expected username to match.");
    }

    @Test
    void testSingletonInstance() {
        UserManagementSystem instance1 = UserManagementSystem.getInstance();
        UserManagementSystem instance2 = UserManagementSystem.getInstance();
        assertSame(instance1, instance2, "Expected the same instance of UserManagementSystem.");
    }
}
