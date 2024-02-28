package repository;

import builder.UserBuilder;
import model.UserDTO;
import service.UtilService;
import serviceImpl.UtilServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private static UserRepository instance = new UserRepository();
    private Map<String, UserDTO> userMap;

    private UserRepository() {
        userMap = new HashMap<>();
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String addUsers() {
        UtilService utilService = UtilServiceImpl.getInstance();
        while (userMap.size() < 5) {
            String username = utilService.createRandomUsername();
            userMap.put(username, new UserBuilder()
                    .username(username)
                    .password("1")
                    .passwordConfirm("1")
                    .name(utilService.createRandomName())
                    .socialSecurityNumber("1234")
                    .phoneNumber("1111")
                    .address("4321")
                    .job("bbb")
                    .build());
        }
        return "더미값 " + userMap.size() + "개 추가";
    }

    public String getUsersCount() {
        return userMap.size() + "개";
    }

    public Map<String, UserDTO> getUserMap() {
        return userMap;
    }

    public String join(UserDTO user) {
        userMap.put(user.getUsername(), user);
        return "회원가입 성공";
    }

    public String login(UserDTO user) {
        UserDTO findUser = userMap.get(user.getUsername());
        return user.getUsername() + " 계정 로그인 " +
                (findUser == null ||
                findUser.getPassword().compareTo(user.getPassword()) != 0?
                "실패" : "성공");
    }
}
