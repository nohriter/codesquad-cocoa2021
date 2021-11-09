# JVM 구조와 자바 런타임 메모리 구조

## JVM(Java Virtual Machine) 이란?

- 자바 가상 머신으로 자바 바이트 코드를 실행할 수 있는 주체이다.
- 운영체제 위에서 동작하는 프로세스로 자바 소스파일을 컴파일해 얻은 바이트코드(클래스 파일)를 기계어로 바꿔 실행 해주는 역할을 한다.
- 따라서 자바코드는 CPU나 운영체제(플랫폼)의 종류와 무관하게 실행이 가능하다.

JVM의 구성을 살펴보면 크게 4가지(Class Loader, Execution Engine, Garbage Collector, Runtime Data Area)로 나뉜다.

![](https://images.velog.io/images/nohriter/post/bc88ae98-fd74-493f-8ea4-7651502e1136/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C.png)
![](https://images.velog.io/images/nohriter/post/c4bee410-0e5f-418d-8966-752b3eb13211/Untitled-13.png)


### 1. 클래스 로더(Class Loader)
자바에서 소스를 작성하면 Person.java 처럼 .java파일이 생성된다.
이 .java 파일을 컴파일 하면 Person.class 파일 바이트 코드가 생성된다.
이렇게 생성된 **class 파일들을 모아서** JVM이 운영체제로부터 할당받은 **Runtime Data Area로 적재하는 역할**을
Class Loder가 한다.(자바 애플리케이션이 실행중일 때 작업이 수행 된다.)

### 2. 실행 엔진(Execution Engine)
클래스 로더에 의해 **적재 된 클래스파일(바이트코드)들을 기계어로 변경해 명령어 단위로 실행**하는 역할을 한다.
명령어를 하나하나 실행하는 인터프리터(Interpreter) 방식이 있고, JIT(Just-In-Time) 컴파일러를 이용하는 방식이 있다.
JIT 컴파일러는 적절한 시간에 전체 바이트 코드를 네이티브 코드로 변경해서 실행 엔진이 네이티브로 컴파일된 코드를 실행 하는것으로 성능을 높이는 방식이다.

### 3. 가비지 컬렉터(Garbage Collector)
Garbage Collector(GC)는 Heap 메모리 영역에 저장된 객체들 중에서 더 이상 참조되지 않는 객체들을 탐색 후 제거하는 역할을 한다.
GC가 역할을 하는 시간은 정확히 언제인지는 알 수 없다.(참조가 없어지자마자 제거되는 것을 보장하지 않음.)
또 다른 특징은 GC가 실행되는 동안 GC를 실행하는 쓰레드외에 모든 쓰레드는 일시정지 된다.
특히 Full GC가 일어나서 수 초간 모든 쓰레드가 정지 된다면 장애로 이어지는 심각한 문제가 생길 수 있다.

### 4. 메모리(Runtime Data area)
JVM 메모리 영역으로 자바 애플리케이션을 실행할 때 사용되는 데이터들을 적재하는 영역이다.
이 영역은 크게 메소드 영역(Runtime Area), 힙 영역(Heap Area), 스택 영역(Stack Area), PC(PC Register), Native Method Stack 으로 나눌 수 있다.
![](https://images.velog.io/images/nohriter/post/d7ac4462-9b86-4b10-b1e6-def4576caad3/%EB%8B%A4%EC%9A%B4%EB%A1%9C%EB%93%9C%20(1).png)

### 1. 메소드 영역(Method Area)
클래스 멤버 변수의 이름, 데이터 타입, 접근 제어자 정보같은 필드 정보와 메소드의 이름, 리턴 타입, 파라미터, 접근 제어자 정보같은 메소드 정보, Type정보(Interface인지 class인지), Constant Pool(상수 풀 : 문자 상수, 타입, 필드, 객체 참조가 저장됨), static 변수, final class 변수등이 생성되는 영역이다.

클래스 멤버 변수의 이름, 데이터 타입, 접근 제어자 정보 같은 **필드 정보**와 메소드의 이름, 리턴 타입, 파라미터, 접근 제어자 정보 같은 **메소드 정보**, **Type정보**(Interface인지 Class인지), **Constant Pool**(상수 풀 : 문자 상수, 타입, 필드, 객체 참조가 저장됨), static 변수, final class 변수등이 생성되는 영역이다.

### 2. 힙 영역(Heap Area)
new 키워드로 생성된 객체와 배열이 생성되는 영역이다.
메소드 영역에 로드된 클래스만 생성이 가능하고,Garbage Collector가 참조되지 않는 메모리를 확인하고 제거하는 영역이다.

### 3. 스택 영역(Stack Area)
지역변수, 파라미터, 리턴 값, 연산에 사용되는 임시 값등이 생성되는 영역이다.
메소드를 호출할 때마다 개별적으로 스택이 생성된다.

### 4. PC Register
**Thread(쓰레드)가 생성될 때마다 생성**되는 영역으로 Program Counter 즉, 현재 쓰레드가 실행되는 부분의 주소와 명령을 저장하고 있는 영역이다. (*CPU의 레지스터와 다름)

이것을 이용해서 쓰레드를 돌아가면서 수행할 수 있게 한다.

### 5. Native Method Stack
자바 외 언어로 작성된 네이티브 코드를 위한 메모리 영역이다.
보통 C/C++등의 코드를 수행하기 위한 스택이다. (JNI)


쓰레드가 생성되었을 때 기준으로
1,2번인 메소드 영역과 힙 영역을 모든 쓰레드가 공유하고,
3,4,5번인 스택 영역과 PC 레지스터, Native method stack은 각각의 쓰레드마다 생성되고 공유되지 않는다.

---

### Heap area & Garbage Collector

힙 영역은 좀 더 살펴봐야하는데 그 이유는 GC의 주요 대상이기 때문이다.

(Stack영역과 Method영역도 GC의 대상이 된다)

- 힙 영역은 우선 5개의 영역(eden, survivor1, survivor2, old, permanent)으로 나뉜다.
  -> JDK7까지는 permanent영역이 heap에 존재했습니다. JDK8부터는 permanent 영역은 사라지고 일부가 "meta space 영역"으로 변경되었습니다.(위의 그림 JDK7 기준입니다.) meta space 영역은 Native stack 영역에 포함되었습니다.
  (survivor영역의 숫자는 의미없고 두 개로 나뉜다는 것이 중요하다)

- 힙 영역을 굳이 5개로 나눈 이유는 효율적으로 GC가 일어나게 하기 위함이다.

GC는 Minor GC와 Major GC로 나뉜다.

#### Minor GC : New 영역에서 일어나는 GC

1. 최초에 객체가 생성되면 Eden영역에 생성된다.

2. Eden영역에 객체가 가득차게 되면 첫 번째 GC가 일어난다.

3. survivor1 영역에 Eden영역의 메모리를 그대로 복사된다. 그리고 survivor1 영역을 제외한 다른 영역의 객체를 제거한다.

4. Eden영역도 가득차고 survivor1영역도 가득차게된다면, Eden영역에 생성된 객체와 survivor1영역에 생성된 객체 중에 참조되고 있는 객체가 있는지 검사한다.

5. 참조 되고있지 않은 객체는 내버려두고 참조되고 있는 객체만 survivor2영역에 복사한다.

6. survivor2영역을 제외한 다른 영역의 객체들을 제거한다.

7. 위의 과정중에 일정 횟수이상 참조되고 있는 객체들을 survivor2에서 Old영역으로 이동시킨다.

**위 과정을 계속 반복, survivor2영역까지 꽉차기 전에 계속해서 Old로 비움
**

#### Major GC(Full GC) : Old 영역에서 일어나는 GC

1. Old 영역에 있는 모든 객체들을 검사하며 참조되고 있는지 확인한다.

2. 참조되지 않은 객체들을 모아 한 번에 제거한다.

Minor GC보다 시간이 훨씬 많이 걸리고 실행중에 GC를 제외한 모든 쓰레드가 중지한다.


* Major GC(Full GC)가 일어나면,
  Old영역에 있는 참조가 없는 객체들을 표시하고 그 해당 객체들을 모두 제거하게 된다.
  그러면서 Heap 메모리 영역에 중간중간 구멍(제거되고 빈 메모리 공간)이 생기는데 이 부분을 없애기 위해 재구성을 하게 된다. (디스크 조각모음처럼 조각난 메모리를 정리함)
  따라서 메모리를 옮기고 있는데 다른 쓰레드가 메모리를 사용해버리면 안되기 때문에 모든 쓰레드가 정지하게 되는 것이다.