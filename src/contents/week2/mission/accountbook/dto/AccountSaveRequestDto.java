package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.AccountContent;
import contents.week2.mission.accountbook.domain.account.Account;

import java.time.LocalDate;

public class AccountSaveRequestDto {
    private LocalDate date;
    private String content;
    private Long income;
    private Long expense;

    public AccountContent toAccount(AccountSaveRequestDto requestDto) {
        return new AccountContent(
                requestDto.getLocalDate(),
                requestDto.getContent(),
                requestDto.getIncome(),
                requestDto.getExpense()
        );
    }

    public AccountSaveRequestDto(LocalDate date, String content, Long income, Long expense) {
        this.date = date;
        this.content = content;
        this.income = income;
        this.expense = expense;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public Long getIncome() {
        return income;
    }

    public Long getExpense() {
        return expense;
    }
}
