package contents.week2.mission.accountbook.domain.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserFileRepository implements UserRepository{
    private static final Map<Long, User> users = new HashMap<>();

    String path = "C:\\winter\\codesquad\\src\\contents\\week2\\mission\\accountbook.txt";
    private final File file = new File(path);

    private Long id = 0L;

    @Override
    public User save(User user) throws IOException {
        user.setId(generatedId());

        users.put(user.getId(), user);

        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream s = new ObjectOutputStream(f);
        s.writeObject(users);
        s.flush();

        return user;
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
    }}
