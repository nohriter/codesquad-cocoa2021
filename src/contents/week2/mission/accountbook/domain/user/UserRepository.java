package contents.week2.mission.accountbook.domain.user;

public interface UserRepository {
    Boolean save(User user);

    Boolean existByName(String name);

    User findByName(String name);
}
