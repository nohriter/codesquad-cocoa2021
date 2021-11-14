package contents.week2.mission.accountbook.domain.user;

import contents.week2.mission.accountbook.domain.account.Account;

public class User {
    private Long id;
    private String name;
    private String password;
    private Account account;

    public User(String name, String password) {
        this.account = new Account();
        this.name = name;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
