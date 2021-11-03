package week1.day3.indian_naming;

import java.util.ArrayList;
import java.util.List;
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

    public List<Integer> parseBirth(String birth) {
        String[] births = birth.split(" ");

        int year = Integer.parseInt(births[0].substring(births[0].length() - 1));
        int month = Integer.parseInt(births[1].substring(births[1].length() - 1));
        int day = Integer.parseInt(births[2].substring(births[2].length() - 1));

        List<Integer> birthList = new ArrayList<>();

        birthList.add(year);
        birthList.add(month);
        birthList.add(day);

        return birthList;
    }

    public String inputBirth() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("생년월일을 입력해 주세요");
        String birth = scanner.nextLine();
        return birth;
    }

}
