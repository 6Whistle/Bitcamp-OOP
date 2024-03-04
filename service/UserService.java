package service;

import model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    String addUsers();

    String getUsersCount();

    String join(User user);

    Map<String, User> getUserMap();

    String login(User user);

    String getUserByUsername(User user);

    String updatePassword(User user);

    String deleteUser(User user);

    List<User> findUsersByName(User user);

    List<User> findUsersByJob(User user);
}
