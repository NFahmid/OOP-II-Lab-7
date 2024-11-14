interface AdminUserActions extends PowerUserActions {
    void modifyUserSettings(String setting);
    void updateUserPrivileges(String userId, String privilege);
}