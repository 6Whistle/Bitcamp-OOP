package serviceImpl;

import model.UserDTO;
import repository.UserRepository;
import service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();

    private UserRepository userRepository;

    private UserServiceImpl() {
        userRepository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        return instance;
    }

    @Override
    public String addUsers() {
        return userRepository.addUsers();
    }

    @Override
    public String getUsersCount() {
        return userRepository.getUsersCount();
    }

    @Override
    public String join(UserDTO user) {
        return userRepository.join(user);
    }

    @Override
    public Map<String, UserDTO> getUserMap() {
        return userRepository.getUserMap();
    }

    @Override
    public String login(UserDTO user) {
        return userRepository.login(user);
    }

    @Override
    public String getUserByUsername(UserDTO user) {
        return userRepository.getUserByUsername(user);
    }

    @Override
    public String updatePassword(UserDTO user) {
        return userRepository.updatePassword(user);
    }

    @Override
    public String deleteUser(UserDTO user) {
        return userRepository.deleteUser(user);
    }

    @Override
    public List<UserDTO> findUsersByName(UserDTO user) {
        return userRepository.findUsersByName(user);
    }

    @Override
    public List<UserDTO> findUsersByJob(UserDTO user) {
        return userRepository.findUsersByJob(user);
    }
}
