# 자바의 신

---

### String 클래스

String 클래스는 유일하게 더하기 연산을 제공한다. 그 이유는 객체에 더하기를 하면 toString() 메소드가 호출되고 그 결과는 더하는 것이다.

#### String 클래스 선언부

~~~java
import java.io.Serializable;

public final class String extends Object
        implements Serializable, Comparable<String>, CharSequence
~~~
클래스 선언문이 좀 긴데 하나씩 짚어 보자.

~~~java
public final class String extends Object
~~~
final 이라고 선언되어 있기 때문에 확장은 불가능하다. 따라서 있는 그대로 사용해야 한다. <br>
Object 클래스를 상속 받았기 때문에 따로 확장된 것은 없다는걸 알 수 있다.

그럼 이제 어떤 인터페이스를 구현해야하는지 알아보자.

- Serializable 인터페이스는 구현해야 하는 메소드가 하나도 없는 특이한 인터페이스다. 해당 인터페이스를 선언하면 
해당 객체를 파일로 저장하거나, 다른 서버에 전송 가능한 상태가 된다고 한다.


- Comparable 인터페이스는 compareTo() 메소드 하나만 선언되어 있는데 이 메소드는 매개 변수로 넘어가는 객체와 현재 객체가 같은지를 비교하는 데 사용된다.
equals 메소드와 같다고 생각 할 수 있지만 메소드의 리턴 타입이 int 형이다. <br>
  비교 값이 같으면 0 , 순서 상에 앞에 있는 경우 -1 , 뒤에 있는 경우 1 를 리턴한다. <br>
  즉 , 객체의 순서를 처리할 때 유용하게 사용될 수 있다.
  

- CharSequence 인터페이스는 해당 클래스가 문자열을 다루기 위한 클래스라는 것을 명시적으로 나타내는데 사용된다. <br>
StringBuilder , StringBuffer 클래스 역시 CharSequence 인터페이스를 구현해 놓아 나중에 한꺼번에 설명하겠다.
  
---
### String 생성자

String 생성자는 되게 많지만 자주 사용하는 생성자는 다음과 같다.

| 생성자 | 설명 |
|:---|:---|
| String(byte[] bytes) | 현재 사용중인 플랫폼의 캐릭터 셋을 사용하여 제공된 byte 배열을 디코딩한 String 객체를 생성한다. |
| String(byte[] bytes, String charsetName | 지정된 이름을 갖는 캐릭터 셋을 사용하여 지정한 byte 배열을 디코딩한 String 객체를 생성한다. |

---
### String 문자열을 byte로 변환하기

생성자의 매개 변수로 받는 byte 배열은 String 클래스에 현재 문자열 값을 byte 배열로 변환하는 다음과 같은 getBytes() 라는 메소드로 변환한다.

| 리턴타입 | 메소드 이름 및 매개 변수 | 설명 |
|:---|:---|:---|
| byte[] | getBytes() | 기본 캐릭터 셋의 바이트 배열을 생성한다. |
| byte[] | getBytes(Charset charset) | 지정한 캐릭터 셋 객체 타입으로 바이트 배열을 생성한다. |
| byte[] | getBytes(String charsetName) | 지정한 이름의 캐릭터 셋을 갖는 바이트 배열을 생성한다. |
<br>

**Q.** 캐릭터 셋 (Charset) , 디코딩은 뭘까? <br>
**A.** 캐릭터 셋은 문자의 집합을 의미한다. 한글 , 영어 등등 특정 나라의 글자를 말한다.
디코딩은 일반적으로 암호화되어 있거나 컴퓨터가 이해할 수 있는 값들을 알아보기 쉽게 변환하는 것을 의미한다.

캐릭터 셋을 좀 더 알아보면 특수 문자(알파벳을 제외한 나라의 문자를 의미) 를 표시할 때 java.nio.Charset 클래스 API 에는 표준 캐릭터 셋이 정해져 있다. <br>
가끔 사이트에서 한글이 깨지는 이유 역시 지정된 캐릭터 셋이 다르기 때문이다. <br>
한글을 처리하기 위해서는 UTF-16이 가장 많이 쓰이며 UTF-8, EUC-KR 도 쓰인다.

보통 같은 프로그램 내에서 문자열을 byte 배열로 만들기 때문에 getBytes() 메소드를 사용하면 된다.

#### <div id = "String"> StringEx </div>
~~~java
public class StringEx {

    public void convert() {
        try {
            String korean = "한글";

            byte[] arr1 = korean.getBytes();

            for (byte data : arr1) {
                System.out.print(data + " ");
            }
            System.out.println();
            String korean2 = new String(arr1);
            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringEx ex = new StringEx();
        ex.convert();
    }
}
~~~

#### 실행결과

>-19 -107 -100 -22 -72 -128 <br>
한글

getBytes() 메소드가 "한글"을  byte 배열로 만들고 for 루프를 이용하여 값을 출력하였다.<br>
byte[] 을 가지고 있는 String 객체를 생성하면 문자열이 그대로 출력되는 것을 확인할 수 있다.

나는 UTF-8 이라서 UTF-16 이랑 다르게 나오는데 임의적으로 UTF-16으로 바꾸면 어떻게 될까?

위의[코드](#String)에서 추가해보자.

~~~java
    public void convert16() {
        try{
            String korean = "한글";
            byte[] arr = korean.getBytes("UTF-16");
            printByteArray(arr);
            String korean2 = new String(arr);
            System.out.println(korean2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
~~~

#### 실행결과

> -2 -1 -43 92 -82 0 <br>
���\� 

UTF-16 으로 변경한 결과 String 클래스에서 글자가 깨져서 나온 것을 확인할 수 있다. <br>
즉 , 잘못된 캐릭터 셋으로 변환을 하면 글자가 깨지는 것이다. 그렇다면 어떻게 글자 깨짐을 방지 할 수 있을까?

위의[코드](#String)에서 수해보자.

~~~java
public void convert16() {
    try{
        String korean = "한글";
        byte[] arr = korean.getBytes("UTF-16");
        printByteArray(arr);
        String korean2 = new String(arr,"UTF-16");
        System.out.println(korean2);

    } catch (Exception e) {
        e.printStackTrace();
    }
}
~~~

#### 실행결과

> -2 -1 -43 92 -82 0 <br>
한글

String korean2 생성하는 과정에 byte 배열 뒤에 캐릭터 셋을 지정하면 정상적으로 출력되는 것을 확인할 수 있다.

**Q.** 공통적으로 코드를 살펴 보면 try-catch 문을 사용한 이유가 있나? <br>
**A.** 위의[코드](#String)들은 UnsupportedEnCodingException 을 발생 시킬 수가 있다.
즉 , 존재하지 않는 캐릭터 셋을 지정할 경우 예외가 발생하는 것을 막고자 try-catch 블록을 사용한 것이다. 물론 throws 를 사용해도 무관하다.

---
### null check

String 혹은 모든 객체를 처리할 때에 null check 를 해야 한다고 책의 필자는 말한다. 그 이유는 뭘까? <br>
객체가 null 이라는 것은 아무것도 할 수 없는 상태라는 뜻이다. null check 를 하지 않으면 객체에 사용할 수 있는 메소드들은 모두 예외를 발생시킨다.

#### <div id = "nullcheck"> nullcheck </div>

~~~java
public class StringNullEx {
    public boolean nullCheck(String data) {
        System.out.println(data.length());

        if (data == null)
            return true;

        else
            return false;
    }

    public static void main(String[] args) {
        StringNullEx ex  = new StringNullEx();
        ex.nullCheck(null);
    }
}
~~~

#### 실행결과

> Exception in thread "main" java.lang.NullPointerException

null 인 객체의 메소드에 접근하였기 때문에 예외가 발생하였다.

그렇다면 해당 문장을 제외하면 실행이 정상적으로 될까?? -> 된다. 

그 이유는 객체가 null 이지만 접근하지 않기 때문에 정상적으로 실행이 된다.

널 체크를 하지않아 애플리케이션이 비정상 작동하여 장애를 일으킬 수도 있고 
메소드의 매개 변수로 넘어오는 객체가 null 이 될 확률이 조금이라도 있다면 null check 하는 습관을 가지고 있어야 한다고 책의 저자는 말한다.

---