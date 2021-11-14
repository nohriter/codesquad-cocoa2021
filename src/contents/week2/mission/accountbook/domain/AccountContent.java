package contents.week2.mission.accountbook.domain;

import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.time.LocalDate;

public class AccountContent {
    private Long id;
    private LocalDate date;
    private String content;
    private Long income;
    private Long expense;

    public AccountContent() {
    }

    public AccountContent(LocalDate date, String content, Long income, Long expense) {
        this.date = date;
        this.content = content;
        this.income = income;
        this.expense = expense;
    }

    public void update(AccountUpdateRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.income = requestDto.getIncome();
        this.expense = requestDto.getExpense();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public boolean isEqualsBy(int month) {
        return this.date.getMonthValue() == month;
    }
}
