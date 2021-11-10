package contents.week2.mission.accountbook.controller;


import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;
import contents.week2.mission.accountbook.service.UserService;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Boolean save(UserSaveRequestDto requestDto) {
        return userService.createUser(requestDto);
    }

    public Boolean login(UserLoginRequestDto requestDto) {
        return userService.login(requestDto);
    }

}
