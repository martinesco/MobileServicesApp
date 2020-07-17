package project.repository;

import project.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private List<User> users;

    public UserStorage(){
        this.setUsers();
    }

    private void setUsers() {
        this.users = new ArrayList<>();

        users.add(new User("Pesho Mladenov","peshito","peshmladenov@abv.bg"));
        users.add(new User("Dedo Hristo","123456","dedohristo@gmail.com"));
    }

    public List<User> getUsers() {
        return users;
    }
}
