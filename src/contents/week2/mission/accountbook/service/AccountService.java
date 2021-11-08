package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.account.Account;
import contents.week2.mission.accountbook.domain.account.AccountMemoryRepository;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountService {

    private final AccountMemoryRepository accountRepository;

    public AccountService(AccountMemoryRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(AccountSaveRequestDto requestDto) {
        Account account = requestDto.toAccount(requestDto);

        System.out.println("account = " + account);

        return accountRepository.create(account);
    }

    public Long updateAccount(Long id, AccountUpdateRequestDto requestDto) {
        return accountRepository.update(id, requestDto);
    }

    public Long deleteAccount(Long id) {
        return accountRepository.delete(id);
    }

    public List<Account> getAccountByMonth() {
        Map<Long, Account> all = accountRepository.findAll();

        List<Account> valueList = new ArrayList<>(all.values());

        return valueList;
    }
}
