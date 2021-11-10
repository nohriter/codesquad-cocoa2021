package contents.week2.mission.accountbook.dto;

import java.time.LocalDate;

public class AccountUpdateRequestDto {
    private LocalDate date;
    private String content;
    private Long income;
    private Long expense;

    public AccountUpdateRequestDto(LocalDate date, String content, Long income, Long expense) {
        this.date = date;
        this.content = content;
        this.income = income;
        this.expense = expense;
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
