# BufferedReader와 Scanner
#### BufferedReader는 InputStreamReader에 버퍼링 기능이 추가된 Class이다.
![](https://images.velog.io/images/nohriter/post/8141d76c-a71a-4ad5-88e9-92001642e666/image.png)

- InputStreamReader는 문자열을 Character 단위(한 글자 단위)로 읽어 들인다.
- 한 글자씩 문자열을 읽어들이는 InputStreamReader의 경우 길이가 긴 문자열을 읽어 들일 때 상당히 불편하고 비효율적이다. 이 점을 보완하고자 BufferedReader가 존재한다.

- 사용자가 요청할 때마다 데이터를 읽어 오는 것이 아닌 일정한 크기의 데이터를 한번에 읽어와 버퍼에 보관 한 후, 사용자의 요청이 있을 때 버퍼에서 데이터를 읽어오는 방식으로 동작한다.
- 그렇기 때문에 속도가 향상되고 시간 부하가 적다는 장점이 있다.
- BufferedReader는 입력을 라인단위로 입력 받기 때문에 공백의 경우에도 String으로 인식한다.
- 입력받은 데이터 타입이 String 타입이므로 다른 타입의 데이터라면 이후 형변환이 필요하다


#### Scanner는 Java1.5 부터 java.util 패키지 내에 포함된 Class이다.
- 공란과 줄바꿈 모두 입력값의 경계로 인식하기 때문에 좀 더 쉽게 데이터를 입력받을 수 있다.
- 데이터 타입이 입력 받는 시점에서 사용하는 함수에 따라 결정되므로 별도의 Casting이 필요하지 않다.


## 참고
- https://carpediem0212.tistory.com/11
