package contents.week2.mission.accountbook.domain.account;

import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;

import java.util.Date;

public class Account {
    private Long id;
    private Date date;
    private String content;
    private Long income;
    private Long expense;

    public Account() {
    }

    public Account(Date date, String content, Long income, Long expense) {
        this.date = date;
        this.content = content;
        this.income = income;
        this.expense = expense;
    }

    public Account(Long id, Date date, String content, Long income, Long expense) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public Date getDate() {
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
