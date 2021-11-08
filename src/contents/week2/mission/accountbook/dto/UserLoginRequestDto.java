package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.user.User;

public class UserLoginRequestDto {
    private String name;
    private String password;

    public User toUser(UserSaveRequestDto requestDto) {
        return new User(
                requestDto.getName(),
                requestDto.getPassword()
        );
    }

    public UserLoginRequestDto() {
    }

    public UserLoginRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
