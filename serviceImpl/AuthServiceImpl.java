package serviceImpl;

import builder.UserBuilder;
import model.UserDTO;
import service.AuthService;
import service.UtilService;

import java.util.*;

public class AuthServiceImpl implements AuthService {
    private static AuthService instance = new AuthServiceImpl();

    private Map<String, UserDTO> users;

    private AuthServiceImpl() {
        users = new HashMap<>();
    }

    public static AuthService getInstance() {
        return instance;
    }

    @Override
    public String addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        while (users.size() < 5) {
            String username = util.createRandomUsername();
            users.put(username, new UserBuilder()
                    .username(username)
                    .password("1")
                    .passwordConfirm("1")
                    .name(util.createRandomName())
                    .socialSecurityNumber("2")
                    .phoneNumber("3")
                    .address("aaa")
                    .job("bbb")
                    .build());
        }
        return "5명이 추가됬습니다.";
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
    public UserDTO findUserByID(String username) {
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
    public String updatePassword(String username, String password) {
        UserDTO user = users.get(username);
        if (user == null) return "계정을 찾을 수 없습니다.";
        user.setPassword(password);
        return "비밀번호 변경 성공";
    }

    @Override
    public String deleteUser(String username) {
        UserDTO user = users.remove(username);
        return user != null ? "성공" : "실패";
    }

    @Override
    public Map<String, UserDTO> getUserMap() {
//        users.forEach((k, v)-> System.out.printf("{%s, %s}", k, v));
        return users;
    }

    @Override
    public List<UserDTO> findUsersByName(String name) {
        List<UserDTO> userList = new ArrayList<>();
        for (String key : users.keySet()) {
            UserDTO value = users.get(key);
            if (name.compareTo(value.getName()) == 0) userList.add(value);
        }
        return userList;
    }

    @Override
    public List<UserDTO> findUsersByJob(String job) {
        List<UserDTO> userList = new ArrayList<>();
        for (String key : users.keySet()) {
            UserDTO value = users.get(key);
            if (job.compareTo(value.getJob()) == 0) userList.add(value);
        }
        return userList;
    }

    @Override
    public String countUsers() {
        return users.size() + "명";
    }
}
