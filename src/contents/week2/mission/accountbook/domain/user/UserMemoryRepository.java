package contents.week2.mission.accountbook.domain.user;

import java.util.HashMap;
import java.util.Map;

public class UserMemoryRepository implements UserRepository {
    private static final Map<Long, User> users = new HashMap<>();
    private Long id = 0L;

    @Override
    public Long save(User user) {
        generatedId();

        users.put(id, user);

        return id;
    }

    public void findById(Long id) {
        users.values()
                .stream()
                .filter(id -> )
    }

    public synchronized void generatedId() {
        id++;
    }
}
