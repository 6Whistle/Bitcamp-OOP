package service;

import model.UserDTO;

import java.util.Map;

public interface UserService {
    public String join();

    public String login();

    public Map<String, UserDTO> addUsers();
}
