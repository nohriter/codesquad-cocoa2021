package week1.day3.indian_naming;

import java.util.HashMap;
import java.util.Map;

public class Birthday {
    private int year;
    private int month;
    private int day;

    private Map<Integer, String> years;
    private Map<Integer, String> months;
    private Map<Integer, String> days;

    public Birthday(String birth) {
        parseBirth(birth);

        createNamingRule();
    }

    public String getYear() {
        return years.get(year);
    }

    public String getMonth() {
        return months.get(month);
    }

    public String getDay() {
        return days.get(day);
    }

    public void parseBirth(String birth) {
        String[] births = birth.split(" ");

        this.year = Integer.parseInt(births[0].substring(births[0].length() - 1));
        this.month = Integer.parseInt(births[1].substring(births[1].length() - 1));
        this.day = Integer.parseInt(births[2].substring(births[2].length() - 1));
    }

    private void createNamingRule() {
        years = new HashMap<>();

        years.put(0, "시끄러운");
        years.put(1, "푸른");
        years.put(2, "어두운");
        years.put(3, "조용한");
        years.put(4, "웅크린");
        years.put(5, "백색");
        years.put(6, "지혜로운");
        years.put(7, "용감한");
        years.put(8, "날카로운");
        years.put(9, "욕심 많은");

        months = new HashMap<>();

        months.put(1, "늑대");
        months.put(2, "태양");
        months.put(3, "양");
        months.put(4, "매");
        months.put(5, "황소");
        months.put(6, "불꽃");
        months.put(7, "나무");
        months.put(8, "달빛");
        months.put(9, "말");
        months.put(10, "돼지");
        months.put(11, "하늘");
        months.put(12, "바람");

        days = new HashMap<>();

        days.put(1, "와(과) 함께 춤을");
        days.put(2, "의 기상");
        days.put(3, "은(는) 그림자 속에");
        days.put(4, "매");
        days.put(5, "의 환생");
        days.put(6, "의 죽음");
        days.put(7, "아래에서");
        days.put(8, "을(를) 보라");
        days.put(9, "이(가) 노래하다");
        days.put(10, "의 일격");
        days.put(11, "에게 쫒기는 남자");
        days.put(12, "의 행진");
        days.put(13, "의 왕");
        days.put(14, "의 유령");
        days.put(15, "을 죽인 자.");
        days.put(16, "은(는) 맨날 잠잔다.");
        days.put(17, "처럼");
        days.put(18, "의 고향");
        days.put(19, "의 전사");
        days.put(20, "은(는) 나의 친구");
        days.put(21, "의 노래");
        days.put(22, "의 정령");
        days.put(23, "의 파수꾼");
        days.put(24, "의 악마");
        days.put(25, "와(과) 같은 사나이");
        days.put(26, "을(를) 쓰러뜨린 자");
        days.put(27, "의 혼");
        days.put(28, "은(는) 말이 없다.");
        days.put(29, "의 배신자");
        days.put(30, "의 인싸");
        days.put(31, "의 마스터");
    }
}
