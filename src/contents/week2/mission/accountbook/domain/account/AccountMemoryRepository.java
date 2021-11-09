package contents.week2.mission.accountbook.domain.account;

import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.HashMap;
import java.util.Map;

public class    AccountMemoryRepository {
    private static final Map<Long, Account> accounts = new HashMap<>();
    private Long id = 0L;

    public Long create(Account account) {
        account.setId(generateId());

        accounts.put(account.getId(), account);

        return id;
    }

    public Long update(Long id, AccountUpdateRequestDto requestDto) {
        Account account = findById(id);

        account.update(requestDto);

        accounts.replace(id, account);

        return id;
    }

    public Long delete(Long id) {
        findById(id);

        accounts.remove(id);

        return id;
    }

    public Map<Long, Account> findAll() {
        return accounts;
    }

    public Account findById(Long id) {
        if (accounts.get(id) == null) {
            throw new IllegalArgumentException("해당 가계부 정보가 없습니다. id = " + id);
        }

        return accounts.get(id);
    }

    public synchronized Long generateId() {
        return id++;
    }

}
