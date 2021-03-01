# 자바의 신

### java.lang.object

상속에서 부모 , 자식 간의 관계에 대하여 알아 보았다. <br>
사실 여기에서 모든 부모 클래스의 위에 Object 라는 클래스가 있다.

~~~java
public class InheritanceObject {
    public static void main(String[] args) {
        InheritanceObject object = new InheritanceObject();
        System.out.println(object.toString());
    }
}
~~~

InheritanceObject라는 클래스에 main메소드 말고는 없지만 toString()이라는 메소드가 선언된 것을 확인할 수 있다. <br>
자바는 여러 클래스를 한번에 받을 수는 없지만 여러 단계로 상속 받을 수는 있다. <br>
Object >> Parent >> Child 순으로 상속 받는다. Child 클래스는 Object 클래스의 자식의 자식이다.

**Q.** 왜 모든 클래스는 Object 클래스의 상속을 받는걸까? <br>
**A.** 가장 큰 이유는 Object 클래스에 있는 메소드들을 통해서 클래스의 기본적인 행동을 정의할 수 있기 때문이다. <br>
클래스 라면 이 정도의 메소드는 정의되어 있어야 하고, 처리해 주어야 한다는 것을 정의하는 작업이 필요하기 때문에 Object 클래스를 상속받았다고 생각하면 될 것 같다.

---
### <div id = "Object"> Object 클래스에서 제공하는 메소드 </div>

Object 클래스에 선언되어 있는 메소드는 객체를 처리하기 위해 메소드와 쓰레드를 위한 메소드로 나뉘는데 우선 객체를 처리하기 위한 메소드 먼저 알아보자.

| 메소드 | 설명 |
|:---|:---|
| protected Object clone () | 객체의 복사본을 만들어 리턴한다. |
| public boolean equals (Object obj) | 현재 객체와 매개 변수로 넘겨받은 객체가 같은지 다른지 확인하여  <br>같으면 true, 다르면 false를 반환한다. |
| <div id = "getClass"> public class<?> getClass () </div>| 현재 객체의 클래스의 객체를 리턴한다. |
| public int hashCode () | 객체에 대한 해시 코드 값을 리턴한다. ( 해시코드 : 16진수로 제공되는 객체의 메모리 주소 ) |
| public String toString () | 객체를 문자열로 표현하는 값을 리턴한다. |

---
### toString ()

Object 클래스에서 가장 많이 사용되며 해당 클래스가 어떤 객체인지 쉽게 나타낼 수 있는 중요한 메소드다.

#### <div id = "toString"> toString </div>

~~~java
public class ToString {
    public static void main(String[] args) {
        ToString string = new ToString();
        string.toStringMethod(string);
    }

    public void toStringMethod(Object obj) {
        System.out.println(obj);
        System.out.println(obj.toString());
        System.out.println("plus " + obj);
    }
}
~~~
toStringMethod 에 첫 줄에는 객체를 출력하게 하였고 <br>
두 번째는 Object 클래스의 상속을 받는 toString () 을 호출하였다. <br>
세 번째는 첫 번째 줄에서 객체의 더하기 연산을 수행하였다.

#### <div id = "result"> 실행결과 </div>

>ToString@14ae5a5 <br>
ToString@14ae5a5 <br>
plus ToString@14ae5a5

객체를 그냥 출력하는 것과 객체의 toString () 메소드를 호출하는 것과 동일한 것을 알 수 있다. <br>
그렇다면 마지막에 더하기 연산을 한 결과도 동일하게 출력이 되었는데 String 을 제외한 참조 자료형에 더하기 연산을 수행하면, 
자동으로 toString () 메소드가 호출되어 객체의 위치에는 String 값이 놓이게 된다. <br>
그럼 객체를 참조할 때에 this 라는 예약어를 사용하면 동일하게 나올까?

위의 [코드](#toString)에서
~~~java
public void toStringMethod(Object obj) {
    System.out.println(this);
    System.out.println(toString());
    System.out.println("plus " + this);
}
~~~
해당 부분만 변경해보자

[실행결과](#result)가 동일하게 나오는 것을 알 수 있다.

**Q.** 그렇다면 toString () 의 결과는 무엇일까? <br>
**A.** getClass().getName() + '@' +Integer.toHexString(hashCode()) 로 실제 Object 클래스에 구현되어 있는 toString() 이다.

[getClass()](#getClass)는 현재 클래스를 호출하는 Object 클래스의 메소드이며 getName()은 현재 클래스의 패키지 이름과 클래스 이름이 나온다. <br>
[hashCode()](#getClass)는 객체의 대한 해시코드 값을 리턴해준다. (16진수로) <br>
Integer.toHexString()은 16진수의 int형 값을 String 값으로 리턴해주는 메서드 이다.

**Q.** 그럼 toString을 왜 쓰는 걸까? 이미 만들어져 있는데 <br>
**A.** 오버라이딩을 적용하여 사용해야 한다. 오버라이딩을 제대로 구현하려면, 접근 제어자, 리턴 타입, 메소드 이름, 매개 변수 타입과 개수가 모두 동일해야 한다.

위의[코드](#toString)에 해당부분을 추가해보자.
~~~java
@Override
public String toString() {     
    return "ToString Class";
}
~~~
#### 실행결과

>ToString Class <br>
ToString Class <br>
plus ToString Class

이전의 [실행결과](#result)와 다른 것을 알 수있다.<br>
방금 수정한 toString 메소드의 내용대로 나오게 되었다.

**Q.** 그렇다면 언제 toString 메소드를 오버라이딩 해야할까?<br>
**A.** 참조자료형에서 배운 DTO를 사용할 떄 toString 메소드를 오버라이딩 하면 내용 확인이 쉽기 때문이다.

예를 들면 이렇게 간편하게 사용 가능하다.
#### <div id = "Member"> Member </div>
~~~java
public class MemerDTO {
    String name;
    String phone;
    String email;

    public MemerDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public static void main(String[] args) {
        MemerDTO dto = new MemerDTO("Lee","010-1234-5678","oxix97@github.com");
        System.out.println(dto);
    }

    @Override
    public String toString() {
        return "name : " + name + "\nphone: " + phone + "\nEmail " + email;
    }
}
~~~

---
### equals

연산자 == 은 두 개의 값이 같은지 다른지 비교하는 연산자이다. 정확히 말하면 값 보다는 주소값을 비교한다.
위의 [코드](#Member)에서 이 부분을 수정해보자.
~~~java
public MemerDTO(String name) {
    this.name = name;
}

public static void main(String[] args) {
    MemerDTO dto1 = new MemerDTO("Lee");
    MemerDTO dto2 = new MemerDTO("Lee");

    if (dto1 == dto2) {
        System.out.println("true");
    }else{
        System.out.println("false");
    }
}
~~~
#### 실행결과
>false

각각의 생성자를 사용하여 만들었기 때문에 주소값이 다르다. -> 주소값이 다르면 연산자 == 는 다른 값이라 생각한다. <br>
그렇다면 equals를 사용하면 true라는 값이 반환될까? <br>
위의[코드]의 해당 부분을 수정해보자.
~~~java
if (dto1.equals(dto2))
~~~

#### 실행결과
>false

동일하게 false 가 나왔다. 그 이유는 equals 메소드에서는 hashCode() 값을 비교하여 해당 객체의 주소값을 리턴한 것을 비교한다.<br>
따라서, 클래스의 인스턴스 변수값이 같다고 하여도 서로 다른 생성자로 생성하였으면 해시 코드가 달라 두 객체는 다르다는 결과가 나온 것이다. <br>
이제 equals 를 오버라이딩 해보자. <br>
완전 정석으로 하는 equals는 다음과 같다.
~~~java
@Override
public boolean equals(Object obj) {     
    
    if (this == obj) return true;
    if (obj == null) return false;

    if(getClass() != obj.getClass()) return false;

    MemberDTO dto = (MemberDTO) obj;

    if(name == null){
        return dto.name.equals(((MemberDTO) obj).name);
    }
    else return name.equals(((MemberDTO) ob).name);

    return true;
}
~~~
API 문서에서 요구하는 equals () 메소드 오버라이딩 할 때에 반드시 다음 다섯 가지의 조건을 만족시켜야 한다고 말한다.

> - 재귀 : null 이 아닌 x라는 객체의 x.equals(x)는 항상 true 값이 나와야 한다.
> - 대칭 : null 이 아닌 x와 y 객체가 있을 때 y.equals(x)가 true 면 , x.equals(y) 역시 true 값을 반환해야 한다.
> - 타동적 : null 이 아닌 x,y,z 가 있을 경우 x.equals(y) , y.equals(z) 모두 true 인 경우 x.equals(z) 역시 true 값을 반환해야 한다.
> - 일관 : null 이 아닌 x,y가 있는 경우 객체가 변경되지 않은 상황에서는 몇 번을 호출하더라도 x.equals(y)의 값은 항상 동일해야한다.
> - null 과의 비교 : null이 아닌 x 라는 객체의 x.equals(null) 결과는 항상 false 여야 한다.


### Question

**Q1.** String a1  = "a" , String a2 = "a" 에서 a1 == a2 가 true 나오는 이유는?

**A1.** 변수 a1, a2 는 stack 메모리? 에 각각 쌓이지만 a1,a2의 값이 같은 경우에는 같은 Heap 메모리?에 저장된다고 한다.

**Q2.** equals와 hashCode 관계

**A2.** equals 메소드를 오버라이딩 해서 값이 같아도 hashCode 값은 서로 다르기 때문에 hashCode() 역시 오버라이딩해서 주소 값도 같게 해야한다.