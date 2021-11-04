package week1.day3.indian_naming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IndianNaming {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        PlayerInfo playerInfo = inputBirth();

        Birthday birthday = new Birthday(playerInfo);

        print(birthday);
    }

    public void print(Birthday birthday) {
        System.out.printf("당신의 이름은 %s %s%s%n", birthday.getYear(), birthday.getMonth(), birthday.getDay());
    }

    public PlayerInfo inputBirth() throws IOException {

        System.out.println("생년월일을 입력해 주세요");

        String year = bufferedReader.readLine();
        String month = bufferedReader.readLine();
        String day = bufferedReader.readLine();

        return new PlayerInfo(year, month, day);

    }

}
