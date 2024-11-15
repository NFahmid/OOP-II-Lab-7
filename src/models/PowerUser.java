package models;

import interfaces.Readable;
import interfaces.Writable;
import services.UserManager;

public class PowerUser extends RegularUser implements Readable, Writable {

    @Override
    public void addUser(String username, String email, String password) {
        UserManager.getInstance().addUser(username, email, password);
    }
}
