package contents.week2.mission.accountbook;

import contents.week2.mission.accountbook.controller.AccountController;
import contents.week2.mission.accountbook.controller.UserController;
import contents.week2.mission.accountbook.domain.account.Account;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static final Scanner scanner = new Scanner(System.in);
    private static final AppConfig appConfig = new AppConfig();
    private static final AccountController accountController = appConfig.accountController();
    private static final UserController userController = appConfig.userController();

    public void run() throws ParseException {
        printMainMenu();
    }

    private void printMainMenu() throws ParseException {
        System.out.println("******************************");
        System.out.println("1.등록");
        System.out.println("2.로그인");
        System.out.println("3.종료");
        System.out.println("******************************");

        String number = scanner.next();

        if (number.equals("3")) {
            return;
        }

        if (number.equals("1")) {
            createUser();
        }

        if (login()) {
            printSecondMenu();
        }

        System.out.println("프로그램을 종료합니다.");
    }

    private Boolean createUser() {
        System.out.println("이름을 입력해주세요.");
        String name = scanner.next();
        System.out.println("비밀번호를 입력해주세요.");
        String password = scanner.next();

        UserSaveRequestDto requestDto = new UserSaveRequestDto(name, password);

        return userController.save(requestDto);
    }

    private void printSecondMenu() throws ParseException {
        while (true) {
            System.out.println("******************************");
            System.out.println("1.가계부 등록");
            System.out.println("2.가계부 수정");
            System.out.println("3.가계부 삭제");
            System.out.println("4.가계부 확인");
            System.out.println("5.종료");
            System.out.println("******************************");
            String number = scanner.next();

            switch (number) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    updateAccount();
                    break;
                case "3":
                    deleteAccount();
                    break;
                case "4":
                    confirmAccount();
                    break;
                case "5":
                    return;
            }
        }
    }

    private void confirmAccount() {
        List<Account> accounts = accountController.printMonthList();

        for(Account a : accounts) {
            SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd");

            String strNewDtFormat = newDtFormat.format(a.getDate());

            System.out.println("날짜: "+strNewDtFormat+
                    "내용: "+a.getContent()+
                    "수입: "+a.getIncome()+
                    "지출: "+a.getExpense()+
                    "잔액: "+(a.getIncome() - a.getExpense()));
        }

    }

    private void deleteAccount() {

    }

    private void updateAccount() {

    }

    private void createAccount() throws ParseException {
        System.out.println("날짜를 입력하세요 ex.2020-12-25");
        String date = scanner.next();
        System.out.println("적요를 입력하세요");
        String content = scanner.next();
        System.out.println("수입을 입력하세요");
        Long income = scanner.nextLong();
        System.out.println("지출을 입력하세요");
        Long expense = scanner.nextLong();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date parseDate = simpleDateFormat.parse(date);

        AccountSaveRequestDto requestDto = new AccountSaveRequestDto(parseDate, content, income, expense);

        accountController.save(requestDto);
    }

    public Boolean login() {

    }
}
