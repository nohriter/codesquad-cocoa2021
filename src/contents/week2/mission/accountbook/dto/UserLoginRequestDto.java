package contents.week2.mission.accountbook.dto;

public class UserLoginRequestDto {
    private String name;
    private String password;

    public UserLoginRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
