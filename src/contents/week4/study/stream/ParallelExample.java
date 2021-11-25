package contents.week4.study.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "홍길동", "신용권", "김자바",
                "람다식", "박병렬"
        );

        //순차 처리
        Stream<String> stream = list.stream();
        stream.forEach(s -> ParallelExample.print(s));
        System.out.println();

        //병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(s -> ParallelExample.print(s));
    }


    public static void print(String s) {
        System.out.println(s + " : " + Thread.currentThread().getName());
    }
}
