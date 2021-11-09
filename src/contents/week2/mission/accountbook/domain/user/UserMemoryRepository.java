package contents.week2.mission.accountbook.domain.user;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserMemoryRepository implements UserRepository {
    private static final Map<Long, User> users = new HashMap<>();
    private Long id = 0L;

    @Override
    public Boolean save(User user) {
        user.setId(generatedId());

        users.put(user.getId(), user);

        return true;
    }

    @Override
    public Boolean existByName(String name) {
        Collection<User> values = users.values();
        for (User user : values) {
            if (user.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public User findByName(String name) {
        Collection<User> values = users.values();

        for (User user : values) {
            if (user.getName().equals(name)) {
                return user;
            }
        }

        throw new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.");
    }

    public synchronized Long generatedId() {
        return id++;
    }
}
