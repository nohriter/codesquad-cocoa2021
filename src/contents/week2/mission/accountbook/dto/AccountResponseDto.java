package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.AccountContent;

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

    public AccountResponseDto(AccountContent accountContent) {
        this.id = accountContent.getId();
        this.date = accountContent.getDate();
        this.content = accountContent.getContent();
        this.income = accountContent.getIncome();
        this.expense = accountContent.getExpense();
    }
}
