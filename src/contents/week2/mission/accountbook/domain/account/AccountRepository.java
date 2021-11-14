package contents.week2.mission.accountbook.domain.account;

public interface AccountRepository {
    Long create(Account account);

    Long update(Long id, AccountUpdateRequestDto requestDto);

    Long delete(Long id);
}
