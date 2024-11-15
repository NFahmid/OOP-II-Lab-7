package interfaces;

public interface AdminPrivileges {
    void updateUser(String username, String newEmail, String newPassword);
    void renameFile(String oldName, String newName);
}
