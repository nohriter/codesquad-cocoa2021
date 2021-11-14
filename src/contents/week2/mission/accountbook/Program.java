package contents.week2.mission.accountbook;

import contents.week2.mission.accountbook.controller.AccountController;
import contents.week2.mission.accountbook.controller.UserController;
import contents.week2.mission.accountbook.domain.AccountContent;
import contents.week2.mission.accountbook.domain.account.Account;
import contents.week2.mission.accountbook.domain.user.User;
import contents.week2.mission.accountbook.dto.AccountResponseDto;
import contents.week2.mission.accountbook.dto.AccountSaveRequestDto;
import contents.week2.mission.accountbook.dto.AccountUpdateRequestDto;
import contents.week2.mission.accountbook.dto.UserLoginRequestDto;
import contents.week2.mission.accountbook.dto.UserSaveRequestDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static final Scanner scanner = new Scanner(System.in);
    private static final AppConfig appConfig = new AppConfig();
    private static final AccountController accountController = appConfig.accountController();
    private static final UserController userController = appConfig.userController();

    public void run() {
        selectMainMenu();
    }

    private void printMainMenu() {
        System.out.println("******************************");
        System.out.println("1.등록");
        System.out.println("2.로그인");
        System.out.println("3.종료");
        System.out.println("******************************");
    }

    //TODO: Enum 으로 변경하기
    private void selectMainMenu() {
        while (true) {
            printMainMenu();

            switch (scanner.next()) {
                case "1":
                    UserLoginRequestDto saveRequestDto = inputUserInfo();
                    if (isValidLoginInfo(saveRequestDto)) {
                        User user = createUser(saveRequestDto);
                        selectSubMenu(user);
                    } else {
                        System.out.println("이미 사용중인 이름입니다.");
                    }
                    break;
                case "2":
                        UserLoginRequestDto loginRequestDto = inputUserInfo();
                    if (isValidLoginInfo(loginRequestDto)) {
                        User user = login(loginRequestDto);
                        selectSubMenu(user);
                    } else {
                        System.out.println("이름 또는 비밀번호를 확인하세요");
                    }
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private User login(UserLoginRequestDto loginRequestDto) {
        return userController.login(loginRequestDto);
    }

    private void printSubMenu() {
        System.out.println("==============");
        System.out.println("1.가계부 등록");
        System.out.println("2.가계부 수정");
        System.out.println("3.가계부 삭제");
        System.out.println("4.가계부 확인");
        System.out.println("5.종료");
        System.out.println("==============");
    }

    private void selectSubMenu(User user) {
        while (true) {
            printSubMenu();

            switch (scanner.next()) {
                case "1":
                    createAccount(user);
                    break;
                case "2":
                    updateAccount();
                    break;
                case "3":
                    deleteAccount();
                    break;
                case "4":
                    printAccountsByMonth(inputMonth());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택해주세요.");
            }
        }
    }

    private UserLoginRequestDto inputUserInfo() {
        System.out.println("이름을 입력해주세요.");
        String name = scanner.next();
        System.out.println("비밀번호를 입력해주세요.");
        String password = scanner.next();

        return new UserLoginRequestDto(name, password);
    }

    // 로그인 및 회원가입
    //TODO: 유효성검사
    private Boolean isValidLoginInfo(UserLoginRequestDto requestDto) {

        return userController.loginInfoCheck(requestDto);
    }

    private User createUser(UserLoginRequestDto userLoginRequestDto) {
        System.out.println("이름을 입력해주세요.");
        String name = scanner.next();
        System.out.println("비밀번호를 입력해주세요.");
        String password = scanner.next();

        UserSaveRequestDto requestDto = new UserSaveRequestDto(name, password);

        return userController.save(requestDto);
    }

    // 가계부
    private void createAccount(User user) {
        System.out.println("날짜를 입력하세요 ex.2020-12-25");
        String inputDate = scanner.next();
        System.out.println("내용을 입력하세요");
        String content = scanner.next();
        System.out.println("수입을 입력하세요");
        Long income = scanner.nextLong();
        System.out.println("지출을 입력하세요");
        Long expense = scanner.nextLong();

        LocalDate accountDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);
        Account account = user.getAccount();

        AccountSaveRequestDto requestDto = new AccountSaveRequestDto(accountDate, content, income, expense);

        accountController.save(requestDto);
    }

    private Boolean updateAccount() {
        System.out.println("수정할 번호를 입력하세요");
        Long accountId = Long.parseLong(scanner.next());
        System.out.println("날짜를 입력하세요 ex.2020-12-25");
        String inputDate = scanner.next();
        System.out.println("내용을 입력하세요");
        String content = scanner.next();
        System.out.println("수입을 입력하세요");
        Long income = scanner.nextLong();
        System.out.println("지출을 입력하세요");
        Long expense = scanner.nextLong();

        LocalDate accountDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_DATE);

        AccountUpdateRequestDto requestDto = new AccountUpdateRequestDto(accountDate, content, income, expense);

        return accountController.update(accountId - 1, requestDto);
    }

    private void deleteAccount() {
        System.out.println("삭제할 번호를 입력하세요");
        Long accountId = Long.parseLong(scanner.next());

        accountController.delete(accountId);
    }

    private int inputMonth() {
        System.out.println("원하는 달을 입력해주세요. ex.12");
        return Integer.parseInt(scanner.next());
    }

    private void printAccountsByMonth(int month) {
        List<AccountResponseDto> accounts = accountController.printAccountsByMonth(month);

        for (AccountResponseDto account : accounts) {
            System.out.printf("%s.날짜: %s\t내용: %s\t수입: %d\t지출: %d\t잔액: %d%n",
                    account.getId() + 1,
                    account.getDate(),
                    account.getContent(),
                    account.getIncome(),
                    account.getExpense(),
                    account.getIncome() - account.getExpense());
        }
    }
}
