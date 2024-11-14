class AdminUser extends PowerUser implements AdminUserActions {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public void modifyUserSettings(String setting) {
        // Logic to modify settings
    }

    @Override
    public void updateUserPrivileges(String userId, String privilege) {
        // Logic to update privileges
    }

    @Override
    public void performRoleSpecificActions() {
        super.performRoleSpecificActions();
        modifyUserSettings("Some setting");
        updateUserPrivileges(userID, "Admin");
    }
}