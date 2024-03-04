package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface AuthService {
    String addUsers();
    String join(User user);
    String login(User user);
    User findUserByID(String username);
    String updatePassword(User user);
    String deleteUser(String username);
    Map<String, User> getUserMap();
    List<User> findUsersByName(String name);
    List<User> findUsersByJob(String job);

    String countUsers();
}
