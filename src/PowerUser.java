class PowerUser extends RegularUser implements PowerUserActions {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password);
    }

    @Override
    public void addUserData(String userData) {

    }

    @Override
    public void performRoleSpecificActions() {
        super.performRoleSpecificActions();
        addUserData("New user data");
    }
}