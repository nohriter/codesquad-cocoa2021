package contents.week2.mission.accountbook.controller;


import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;
import contents.week2.mission.accountbook.service.UserService;

public class UserController {

    private final contents.week2.mission.accountbook.service.UserService UserService;

    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    public Boolean save(UserSaveRequestDto requestDto) {
        UserService.createUser(requestDto);

        return true;
    }

    public Boolean login(UserLoginRequestDto requestDto){
        return UserService.login(requestDto);
    }

}
