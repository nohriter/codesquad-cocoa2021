package contents.week2.mission.accountbook.domain.user;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface
UserRepository {
    User save(User user) throws IOException;

    Boolean existByName(String name);

    User findByName(String name);
}
