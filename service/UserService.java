package service;

import model.UserDTO;

import java.util.Map;

public interface UserService {
    String join(UserDTO user);

    String login(UserDTO user);

    Map<String, UserDTO> addUsers();

    UserDTO findUser(String username);
    Map<String, UserDTO> getUserMap();
    String countUsers();
}
