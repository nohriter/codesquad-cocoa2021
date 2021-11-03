package week1.day3.indian_naming;

import java.util.Scanner;

public class IndianNaming {

    public void run() {
        String inputDay = inputBirth();

        Birthday birthday = new Birthday(inputDay);

        print(birthday);
    }

    public void print(Birthday birthday) {
        System.out.printf("당신의 이름은 %s %s%s%n", birthday.getYear(), birthday.getMonth(), birthday.getDay());
    }

    public String inputBirth() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("생년월일을 입력해 주세요");
        String birth = scanner.nextLine();
        return birth;
    }

}
