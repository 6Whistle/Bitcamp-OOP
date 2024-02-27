package serviceImpl;

import builder.UserBuilder;
import model.UserDTO;
import service.UserService;
import service.UtilService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private static UserService instance = new UserServiceImpl();

    Map<String, UserDTO> users;
    private UserServiceImpl(){  users = new HashMap<>();  }

    public static UserService getInstance(){
        return instance;
    }
    @Override
    public String join(UserDTO user) {
        users.put(user.getName(), user);
        return "회원가입 성공 : " + user.toString();
    }

    @Override
    public String login(UserDTO user) {
        System.out.println(user);
        UserDTO findUser = users.get(user.getUsername());
        return findUser == null ? "아이디 없음" :
               findUser.getPassword().compareTo(user.getPassword()) != 0 ? "아이디 불일치" :
               "성공";
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

    @Override
    public UserDTO findUser(String username) {
        UserDTO findUser = users.get(username);
        return new UserBuilder()
                .username(findUser.getUsername())
                .password(findUser.getPassword())
                .passwordConfirm(findUser.getPasswordConfirm())
                .name(findUser.getName())
                .socialSecurityNumber(findUser.getSocialSecurityNumber())
                .phoneNumber(findUser.getPhoneNumber())
                .address(findUser.getAddress())
                .job(findUser.getJob())
                .build();
    }

    @Override
    public Map<String, UserDTO> getUserMap() {
        return users;
    }

    @Override
    public String countUsers() {
        return users.size() + "명";
    }
}
