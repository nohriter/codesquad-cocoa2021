package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.user.User;
import contents.week2.mission.accountbook.domain.user.UserMemoryRepository;
import contents.week2.mission.accountbook.domain.user.UserRepository;
import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;

public class UserService {

    private final UserRepository userMemoryRepository;

    public UserService(UserMemoryRepository userMemoryRepository) {
        this.userMemoryRepository = userMemoryRepository;
    }

    public User createUser(UserSaveRequestDto requestDto) {
        User user = requestDto.toUser(requestDto);

        return userMemoryRepository.save(user);
    }

    public User login(UserLoginRequestDto requestDto) {
        return userMemoryRepository.findByName(requestDto.getName());
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
