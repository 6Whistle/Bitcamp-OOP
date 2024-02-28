package service;

import model.UserDTO;

import java.util.Map;

public interface UserService {

    String addUsers();

    String getUsersCount();

    String join(UserDTO user);

    Map<String, UserDTO> getUserMap();

    String login(UserDTO user);
}
