package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.user.User;
import contents.week2.mission.accountbook.domain.user.UserMemoryRepository;
import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;

public class UserService {

    private final UserMemoryRepository userMemoryRepository;

    public UserService(UserMemoryRepository userMemoryRepository) {
        this.userMemoryRepository = userMemoryRepository;
    }

    public Long createUser(UserSaveRequestDto requestDto) {
        User user = requestDto.toUser(requestDto);

        return userMemoryRepository.save(user);
    }

    public Boolean login(UserLoginRequestDto requestDto) {
        requestDto.
        return ;
    }
}
