package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.user.User;
import contents.week2.mission.accountbook.domain.user.UserMemoryRepository;
import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;

import java.util.Collection;

public class UserService {

    private final UserMemoryRepository userMemoryRepository;

    public UserService(UserMemoryRepository userMemoryRepository) {
        this.userMemoryRepository = userMemoryRepository;
    }

    public Boolean createUser(UserSaveRequestDto requestDto) {
        User user = requestDto.toUser(requestDto);

        if (existByName(requestDto.getName())) {
            return false;
        }

        return userMemoryRepository.save(user);
    }

    public Boolean login(UserLoginRequestDto requestDto) {
        return isValidLoginInfo(requestDto);
    }

    public Boolean isValidLoginInfo(UserLoginRequestDto requestDto) {
        try {
            User user = userMemoryRepository.findByName(requestDto.getName());

            if (requestDto.getPassword().equals(user.getPassword())) {
                return true;
            }

        } catch (IllegalArgumentException e) {
            return false;
        }

        return false;
    }

    private boolean existByName(String name) {
        return userMemoryRepository.existByName(name);
    }
}
