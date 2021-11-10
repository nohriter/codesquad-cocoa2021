package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.account.Account;
import contents.week2.mission.accountbook.domain.account.AccountMemoryRepository;
import contents.week2.mission.accountbook.dto.AccountResponseDto;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AccountService {

    private AccountMemoryRepository accountRepository;

    public AccountService(AccountMemoryRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(AccountSaveRequestDto requestDto) {
        Account account = requestDto.toAccount(requestDto);

        return accountRepository.create(account);
    }

    public Long updateAccount(Long id, AccountUpdateRequestDto requestDto) {
        return accountRepository.update(id, requestDto);
    }

    public Long deleteAccount(Long id) {
        return accountRepository.delete(id);
    }

    public List<AccountResponseDto> getAccountByMonth(int month) {
        Map<Long, Account> all = accountRepository.findAll();
        Collection<Account> values = all.values();

        List<AccountResponseDto> responseAccountList = new ArrayList<>();

        for(Account account : values) {
            if(account.isEqualsBy(month)) {
                responseAccountList.add(new AccountResponseDto(account));
            }
        }

        return responseAccountList;
    }
}
