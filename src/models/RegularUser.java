package models;

import interfaces.Readable;
import services.UserManager;

public class RegularUser implements Readable {
    @Override
    public void viewUsers() {
        UserManager.getInstance().readUsers();
    }
}
