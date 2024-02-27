package controller;

import model.UserDTO;
import serviceImpl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class UserController {
    Map<String, UserDTO> users;

    UserController(){   users = new HashMap<>();    }

    public void addUsers(){
        users = UserServiceImpl.getInstance().addUsers();
    }

    public void findUser(String username){
        System.out.println(users.get(username));
    }
}
