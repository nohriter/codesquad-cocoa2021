package contents.week2.mission.accountbook.domain.account;

import contents.week2.mission.accountbook.domain.AccountContent;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.HashMap;
import java.util.Map;

public class AccountMemoryRepository {
    private static final Map<Long, AccountContent> accountContents = new HashMap<>();
    private Long id = 0L;

    public Long create(AccountContent accountContent) {
        accountContent.setId(generateId());

        accountContents.put(accountContent.getId(), accountContent);

        return id;
    }

    public Long update(Long id, AccountUpdateRequestDto requestDto) {
        AccountContent accountContent = findById(id);

        accountContent.update(requestDto);

        accountContents.replace(id, accountContent);

        return id;
    }

    public Long delete(Long id) {
        findById(id);

        accountContents.remove(id);

        return id;
    }

    public Map<Long, AccountContent> findAll() {
        return accountContents;
    }

    public AccountContent findById(Long id) {
        if (accountContents.get(id) == null) {
            throw new IllegalArgumentException("해당 가계부 정보가 없습니다. id = " + id);
        }

        return accountContents.get(id);
    }

    public synchronized Long generateId() {
        return id++;
    }

}
