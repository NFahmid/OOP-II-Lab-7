class RegularUser extends User implements RegularUserActions {
    public RegularUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Regular");
    }

    @Override
    public void viewUserData() {

    }

    @Override
    public void performRoleSpecificActions() {
        viewUserData();
    }
}