package serviceImpl;

import builder.UserBuilder;
import model.UserDTO;
import service.UserService;
import service.UtilService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();

    private UserServiceImpl(){}

    public static UserService getInstance(){
        return instance;
    }
    @Override
    public String join() {
        return null;
    }

    @Override
    public String login() {
        return null;
    }

    @Override
    public Map<String, UserDTO> addUsers(){
        Map<String, UserDTO> users = new HashMap<>();
        UtilService util = UtilServiceImpl.getInstance();

        while(users.size() < 5){
            String username = util.createRandomUsername();
            users.put(username, new UserBuilder()
                                    .username(username)
                                    .password("1")
                                    .passwordConfirm("1")
                                    .name(util.createRandomName())
                                    .build());
        }
        return users;
    }
}
