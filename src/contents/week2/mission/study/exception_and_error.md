### 오류(error)와 예외(exception)

**에러의 종류**

---

- 컴파일 오류
    - 컴파일할 때 발생
    - 예시) 세미콜론 누락, 선언되지 않은 변수 사용
- 런타임 오류
    - 에러(Error)
        - 실행 단계에서 발생
        - 시스템 레벨에서 발생
        - 미리 예측할 수 없음
        - 예시) 메모리 부족(OutOfMemoryError)
    - 예외(Exception)
        - 실행 단계에서 발생
        - 개발자가 구현한 코드에서 발생
        - 미리 예측하여 처리가 가능함
        - 예시) NullPointerException

**예외 클래스**

---

![](https://www.nextree.co.kr/content/images/2021/01/Exception-Class.png)

출처: [https://www.nextree.co.kr/p3239/](https://www.nextree.co.kr/p3239/)

- 모든 예외는 Throwable 클래스를 상속 받고 있다.
- Exception은 수 많은 자식 클래스가 있다.
    - RuntimeException은 CheckedException 과 UncheckedException을 구분하는 기준이다.
    - Exception의 자식 클래스 중 RuntimeException을 제외한 클래스는 CheckedException이다.
    - RuntimeException과 그의 자식 클래스들을 Unchecked이라 부른다.

**Checked Exception과 Unchecked Exception**

---

![Untitled](https://www.nextree.co.kr/content/images/2021/01/exception-table.png)

출처: [https://www.nextree.co.kr/p3239/](https://www.nextree.co.kr/p3239/)

참고
[https://www.nextree.co.kr/p3239/](https://www.nextree.co.kr/p3239/)
