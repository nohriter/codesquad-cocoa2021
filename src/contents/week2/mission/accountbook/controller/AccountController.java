package contents.week2.mission.accountbook.controller;

import contents.week2.mission.accountbook.dto.AccountResponseDto;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;
import contents.week2.mission.accountbook.service.AccountService;

import java.util.List;

public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Long save(AccountSaveRequestDto requestDto) {
        return accountService.createAccount(requestDto);
    }

    public Boolean update(Long id, AccountUpdateRequestDto requestDto) {
        accountService.updateAccount(id, requestDto);

        return true;
    }

    public Long delete(Long id) {
        return accountService.deleteAccount(id);
    }

    public List<AccountResponseDto> printAccountsByMonth(int month) {
        return accountService.getAccountByMonth(month);
    }
}
