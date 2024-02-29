package serviceImpl;

import builder.UserBuilder;
import model.UserDTO;
import repository.UserRepository;
import service.AuthService;
import service.UtilService;

import java.awt.color.ICC_ColorSpace;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        users.put(user.getUsername(), user);
        return "회원가입 성공";
    }

    @Override
    public String login(UserDTO user) {
        return users.getOrDefault(user.getUsername(), new UserBuilder().password("").build())
                .getPassword()
                .equals(user.getPassword()) ?
                "로그인 성공" : "로그인 실패";
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
    public String updatePassword(UserDTO user) {
        users.getOrDefault(user.getUsername(), new UserBuilder().password("").build())
                .setPassword(user.getPassword());
        return "비밀번호 변경 성공";
    }

    @Override
    public String deleteUser(String username) {
        return Objects.isNull(users.remove(username)) ? "실패" : "성공";
    }

    @Override
    public Map<String, UserDTO> getUserMap() {
        return new HashMap<>(users);
    }

    @Override
    public List<UserDTO> findUsersByName(String name) {
        return users.values().stream().filter(i->i.getName().equals(name)).toList();
    }

    @Override
    public List<UserDTO> findUsersByJob(String job) {
        return users.values().stream().filter(i->i.getJob().equals(job)).toList();
    }

    @Override
    public String countUsers() {
        return users.size() + "명";
    }
}
