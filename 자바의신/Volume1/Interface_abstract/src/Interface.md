# 자바의 신

### Interface

자바에는 클래스 파일을 만들 수 있는 것에는 클래스만 있는 것이 아니라 인터페이스 , 추상 클래스라는 것이 있다. <br>
이 두가지를 제대로 알기 위해서는 시스템 만드는 절차가 어떻게 진행되는지 알아야 한다. <br>
어떠한 시스템을 개발할 때 방법론 이라는 것을 사용하여 개발 하는데 일반적인 절차는 다음과 같다.

- 분석
- 설계
- 개발 및 테스트
- 시스템 릴리즈

---
#### 분석

시스템을 분석하는 단계에서는 시스템을 만들어 달라고 요청한 고객에게 어떻게 개발하기를 원하는지 물어본다. <br>
이러한 일종의 과정을 요구사항 분석이라고 한다.

---
#### 설계

설계 단계에서는 분석 단계에서 만든 대략적인 그림을 프로그램으로 만들 수 있도록 설계하는 작업을 수행한다. <br>
이 단계에서 어떤 메소도를 만들고 , 데이터는 어떻게 저장할지 등등 세부적인 것을 정리한다.

---
#### 개발 및 테스트

설계에서 만들기로 한 것을 개발하는 단계이며, 실제 시스템에서 제공해야 하는 기능들을 이 때 만든다. <br>
만드는 작업을 개발이라고 하며, 필요한 기능들이 제대로 동작하는지 확인하는 테스트 작업을 한다.

---
#### 시스템 릴리즈

시스템을 사용자들에게 제공하는 단계이며 시스템을 오픈한 이후에는 운영 / 유지보수 단계를 거치면서 문제가 있는 부분을 고쳐나간다.

---
#### 인터페이스, 추상클래스를 사용해야 하는 이유

예를들어 설명하면 리모컨 같은 경우에 전원버튼이 있는데 전원버튼을 누르면 전자 기기의 전원이 꺼진다는 사실은 누구나 다 알지만 그 구동 원리를 대부분 모르며 사용자 입장에서 알 이유도 없다.<br>
마찬가지로 Object 클래스의 equals 메소드 역시 메소드에 객체가 같으면 true, 다르면 false 를 반환하는건 다 알지만 구체적으로 어떻게 구현되어 있는지는 확인해봐야한다. <br>
사용자의 입장에서 내부 구현이 별로 궁금하지 않고, 원하는 메소드를 호출하고 그 답을 받는다는게 핵심이다. <br>
가장 일반적인 것이 DAO ( Data Access Object )라는 패턴으로 데이터를 저장하는 저장소에서 원하는 값을 요청하고 응답을 받는다.

---

- 설계시 선언하면 개발할 때 기능을 구현하는데 집중할 수 있다.
- 개발자의 역량에 따른 메소드를 이름과 매개 변수 선언의 격차를 줄일 수 있다.
- 공통적인 인터페이스와 추상클래스를 선언하면 , 선언과 구현을 구분할 수 있다.

---
### 인터페이스

인터페이스는 선언부가 클래스가 아닌 public interface로 되어 있으며 내부에 선언된 메소드들은 내용이 있으면 안된다.
#### <div id = "Membermanger"> MemberManager </div>

~~~java
public interface MemberManager {
    public boolean addMember(MemberDTO member);
    public boolean removeMember(String name, String phone);
    public boolean updateMember(MemberDTO member);
}
~~~

이렇게 만든 인터페이스는 다음과 같이 활용한다.

#### <div id = "MemberManagerImpl"> MemberManagerImpl </div>
~~~java
public class MemberManagerImpl implements MemberManager {
    
}
~~~
클래스 선언문 보면 implements 라는 단어 뒤에 인터페이스를 추가한 것을 확인할 수 있다. <br>
상속은 한개 밖에 안되지만 인터페이스는 여러 개 받을 수 있다. 상속과는 다른 구현한다는 표현이 맞는거 같다. <br>
실행해보면 오류가 나게 되는데 이유는 인터페이스를 구현할 경우 인터페이스에 정의된 메소드들을 구현해야만 한다. <br>
다음과 같이 구현하면 된다.

~~~java
public class MemberManagerImpl implements MemberManager {

    @Override
    public boolean addMember(MemberDTO member) {
        return false;
    }

    @Override
    public boolean removeMember(String name, String phone) {
        return false;
    }

    @Override
    public boolean updateMember(MemberDTO member) {
        return false;
    }
}
~~~
정리해보면, 설계 단계에서 인터페이스만 만들어 놓고, 개발 단계에서 실제 작업을 수행하는 메소드를 만들면 보다 효율적이다. <br>
인터페이스는 효율적인 작업 뿐만 아니라 외부에 노출되는 것을 정의해 놓고자 할 때 사용한다. <br>

---
### abstract 클래스

일반적인 클래스도 아니고 인터페이스도 아닌 추상 클래스는 class 라는 예약어 앞에 abstract 라는 예약어를 사용하며 <br>
각 메소드 선언문은 일반 메소드 선언문과 동일하지만 메소드 내용( 몸통 )이 없다.

예를 들면

~~~java
public abstract class MemberManagerAbstract {
    public abstract boolean addMember(MemberDTO member);
    public abstract boolean removeMember(String name, String phone);
    public abstract boolean updateMember(MemberDTO member);
    public void print(String data){
        System.out.println("data " + data);
    }
}
~~~

추상 클래스는 abstract 로 선언한 메소드가 하나라도 있을 때 선언한다. <br>
인터페이스와 다른점은 구현되어 있는 메소드가 있어도 상관없다. <br>
또한, 클래스이기 때문에 implements 로 구현받는게 아니라 extends 로 상속받는 클래스이다.

메인 메소드에서 상속받고 실행하면 인터페이스에서 났던 오류랑 역시 동일하게 나며 추상클래스를 상속받았으면 반드시 구현해야한다.

**Q.** 인터페이스나 추상클래스나 하는 일이 비슷한데 굳이 나눈 이유가 있을까?? <br>
**A.** 어떤 메소드는 미리 만들어 놓아도 전혀 문제가 없는 경우 해당 클래스를 만들기는 애매하고 공통적인 기능을 미리 구현해 놓으면 많은 도움이 된다고 한다.

---
#### 인터페이스와 추상 클래스의 차이를 정리해보자.

| | 인터페이스 | 추상 클래스 | 클래스 |
|:---|:---|:---|:---|
| 선언 시 사용하는 예약어 | interface | abstract class | class |
| 구현 안 된 메소드 포함 가능 여부 | 가능 (필수) | 가능 | 불가 |
| 구현된 메소드 포함 가능 여부 | 불가 | 가능 | 가능 (필수) |
| static 메소드 선언 가능 여부 | 불가 | 가능 | 가능 |
| final 메소드 선언 가능 여부 | 불가 | 가능 | 가능 |
| 상속 가능 여부 | 불가 | 가능 | 가능 |
| 구현 가능 여부 | 가능 | 불가 | 불가 |

중요한 점은 extends 뒤에 클래스가 1개만 존재 할 수 있으며 , implements 뒤에는 여러 개 존재 할 수 있다는 것이다.

---
### final

final 이라는 예약어는 클래스, 메소드, 변수에 선언 가능하며 final 이라는 예약어를 쓰게 되면 상속해 줄 수가 없다. <br>
예를 들면

~~~java
final class FinalClass{
    
}
public class FinalClassChild extends FinalClass{
    
}
~~~

---
#### 실행결과

> <span style = "color : red"> java: cannot inherit from final FinalClass </span>

상속을 받을 수 없다고 오류가 나온다. 

**Q.** final 예약어를 사용하는 이유는 무엇일까? <br>
**A.** 중요한 클래스를 누군가 상속받아서 더 확장해서는 안 되는 클래스에다가 final 선언하면 된다.

메소드 역시 final 사용할 수있는데 클래스와 같은 이유로 final 선언을 하면 더 이상 오버라이딩 하는 것이 불가능하다.

변수에도 final 적용이 가능한데 클래스, 메소드 사용 방식이랑 비슷할까? <br>
변수는 조금 다르다. 변수에 final 적용을 시키면 더 이상 그 변수의 값을 변경하지 못하며 상수로 사용하게 된다. <br>
그래서, 인스턴스 변수나 static 으로 선언된 클래스 변수는 선언과 함께 값을 지정해야만 한다.

~~~java
public class FinalVariable {
    final static int value = 1;

    public static void main(String[] args) {
        System.out.println(value);
        System.out.println(++value);
    }
}
~~~

#### 실행결과

> <span style = "color : red"> java: cannot assign a value to final variable value </span>

이와 같이 변경이 불가능 하다는 오류가 나오게 된다. <br>

기본 자료형 말고 참조 자료형도 final 이라는 예약어를 붙일 경우에는 어떻게 될까??

~~~java
public class FinalReferenceType {
    final MemberDTO dto = new MemberDTO();

    public static void main(String[] args) {
        FinalReferenceType referenceType = new FinalReferenceType();
        referenceType.checkDTO();
    }

    public void checkDTO() {
        System.out.println(dto);
        //dto = new MemberDTO();
        dto.name = "LEE";
        System.out.println(dto);
    }
}
~~~

#### 실행결과

>name : null phone: null Email null <br>
name : LEE phone: null Email null

**Q.** 실행 결과가 같게 나오는데 final 예약어가 안되는 것인건가?? <br>
**A.** MemberDTO 클래스의 객체는 FinalReferenceType 에서 두 번 이상 생성할 수 없다. <br>
하지만, 객체 안의 내용은 final 예약어를 사용한 것이 없기 때문에 해당 클래스가 final 이라고 해서 그 안에 있는 인스턴스 변수나 클래스 변수가 final 은 아니다.

---


