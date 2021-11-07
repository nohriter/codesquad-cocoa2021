# Call by value와 Call by reference

- 함수의 호출 방식에는 Call by value와 Call by reference가 있다.
- Call by value = 값에 의한 호출
- Call by reference = 참조에 의한 호출

### Call by value
```java
public class CallByValue {
    public static void swap(int x, int y) {

        int temp = x;

        x = y;

        y = temp;

    }


    public static void main(String[] args) {

        int a = 10;

        int b = 20;


        System.out.println("swap() 호출 전 : a = " + a + ", b = " + b);


        swap(a, b);


        System.out.println("swap() 호출 후 : a = " + a + ", b = " + b);

    }
}

```

<br/>

#### 결과
```java
swap() 호출 전 : a = 10, b = 20

swap() 호출 후 : a = 10, b = 20
```

> Call by value는 메서드 호출 시에 사용되는 인자의 메모리에 저장되어 있는 값(value)을 복사하여 보낸다.
<br/>
---

<br/>

### Call by reference
```java
public class CallByReference {
    int value;

    CallByReference(int value) {
        this.value = value;
    }


    public static void swap(CallByReference x, CallByReference y) {
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }


    public static void main(String[] args) {
        CallByReference a = new CallByReference(10);
        CallByReference b = new CallByReference(20);

        System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);

        swap(a, b);

        System.out.println("swap() 호출 전 : a = " + a.value + ", b = " + b.value);

    }
}
```
<br/>

#### 결과
```java
swap() 호출 전 : a = 10, b = 20

swap() 호출 후 : a = 20, b = 10
```

> Call by reference는 메서드 호출 시 사용되는 인자 값의 메모리에 저장되어있는 주소(Address)를 복사하여 보낸다.

## 참고
- https://re-build.tistory.com/3
