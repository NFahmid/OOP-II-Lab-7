package models;

import interfaces.AdminPrivileges;
import interfaces.Readable;
import interfaces.Writable;
import services.UserManager;

public class AdminUser extends PowerUser implements Readable, Writable, AdminPrivileges {

    @Override
    public void updateUser(String username, String newEmail, String newPassword) {
        UserManager.getInstance().updateUser(username, newEmail, newPassword);
    }

    @Override
    public void renameFile(String oldName, String newName) {
        UserManager.getInstance().renameFile(oldName, newName);
    }
}
