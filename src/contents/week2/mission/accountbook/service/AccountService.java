package contents.week2.mission.accountbook.service;

import contents.week2.mission.accountbook.domain.AccountContent;
import contents.week2.mission.accountbook.domain.account.Account;
import contents.week2.mission.accountbook.domain.account.AccountMemoryRepository;
import contents.week2.mission.accountbook.domain.account.AccountRepository;
import contents.week2.mission.accountbook.dto.AccountResponseDto;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(AccountSaveRequestDto requestDto) {
        AccountContent accountContent = requestDto.toAccount(requestDto);

        return accountRepository.create(accountContent);
    }

    public Long updateAccount(Long id, AccountUpdateRequestDto requestDto) {
        return accountRepository.update(id, requestDto);
    }

    public Long deleteAccount(Long id) {
        return accountRepository.delete(id);
    }

    public List<AccountResponseDto> getAccountByMonth(int month) {
        Map<Long, AccountContent> all = accountRepository.findAll();
        Collection<AccountContent> values = all.values();

        List<AccountResponseDto> responseAccountList = new ArrayList<>();

        for (AccountContent accountContent : values) {
            if (accountContent.isEqualsBy(month)) {
                responseAccountList.add(new AccountResponseDto(accountContent));
            }
        }

        return responseAccountList;
    }
}
