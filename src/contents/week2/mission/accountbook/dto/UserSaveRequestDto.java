package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.user.User;

public class UserSaveRequestDto {
    private String name;
    private String password;

    public User toUser(UserSaveRequestDto requestDto) {
        return new User(
                requestDto.getName(),
                requestDto.getPassword()
        );
    }

    public UserSaveRequestDto() {
    }

    public UserSaveRequestDto(String name, String password) {
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
