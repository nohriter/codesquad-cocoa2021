package contents.week2.mission.accountbook.controller;

import contents.week2.mission.accountbook.domain.user.User;
import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;
import contents.week2.mission.accountbook.service.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User save(UserSaveRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    public User login(UserLoginRequestDto requestDto) {
        return userService.login(requestDto);
    }

    public Boolean loginInfoCheck(UserLoginRequestDto requestDto) {
        return userService.isValidLoginInfo(requestDto);
    }

}
