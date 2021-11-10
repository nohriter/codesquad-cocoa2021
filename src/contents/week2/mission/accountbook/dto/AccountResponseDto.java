package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.account.Account;

import java.time.LocalDate;

public class AccountResponseDto {
    private Long id;
    private LocalDate date;
    private String content;
    private Long income;
    private Long expense;

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
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

    public AccountResponseDto(Account account){
        this.id = account.getId();
        this.date = account.getDate();
        this.content = account.getContent();
        this.income = account.getIncome();
        this.expense = account.getExpense();
    }
}
