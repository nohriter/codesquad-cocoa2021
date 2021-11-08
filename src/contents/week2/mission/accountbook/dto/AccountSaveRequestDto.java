package contents.week2.mission.accountbook.dto;

import contents.week2.mission.accountbook.domain.account.Account;

import java.util.Date;

public class AccountSaveRequestDto {
    private Date date;
    private String content;
    private Long income;
    private Long expense;

    public Account toAccount(AccountSaveRequestDto requestDto) {
        return new Account(
                requestDto.getDate(),
                requestDto.getContent(),
                requestDto.getIncome(),
                requestDto.getExpense()
        );
    }


    public AccountSaveRequestDto() {
    }

    public AccountSaveRequestDto(Date date, String content, Long income, Long expense) {
        this.date = date;
        this.content = content;
        this.income = income;
        this.expense = expense;
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
