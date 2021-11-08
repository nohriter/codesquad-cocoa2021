package contents.week2.mission.accountbook.dto;

public class AccountUpdateRequestDto {
    private String content;
    private Long income;
    private Long expense;

    public AccountUpdateRequestDto() {
    }

    public AccountUpdateRequestDto(String content, Long income, Long expense) {
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
