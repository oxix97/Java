# 자바의 신

---

### String 클래스의 메소드

String 클래스의 내용을 비교하고 검색하는 메소드들을 알아보자.

- 문자열의 길이를 확인하는 메소드
- 문자열이 비어 있는지 확인하는 메소드
- 문자열이 같은지 비교하는 메소드
- 특정 조건에 맞는 문자열이 있는지 확인하는 메소드

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
|:---|:---|:---|
| int | length() | 문자열의 길이 리턴 |
| boolean | isEmpty() | 문자열이 비어있는지 리턴한다. 비어 있는 경우 true, 그렇지 않으면 false |

문자열이 같은지 비교하는 메소드는 많지만 3가지로 분류가 가능하다.

- equals
- compareTo
- contentEquals

| 리턴 타입 |  메소드 이름 및 매개 변수 |
|:---|:---|
| boolean | equals(Object object) |
| boolean | equalsIgnoreCase(String str) |
| int | compareTo(String str) |
| int | compareToIgnoreCase(String str) |
| boolean | contentEquals(CharSequence cs) |
| boolean | contentEquals(CharSequence cs) |

모든 메소드들은 매개 변수로 넘어온 값과 String 객체가 같은지를 비교하기 위한 메소드이다. <br>
IgnoreCase 인 경우에는 대소문자 구분을 안하는 경우이다.

#### <div id = "check"> checkCompare </div>

~~~java
public class Checkable {
    public void checkCompare() {
        String str1 = "Check";
        String str2 = "Check";

        if(str1 == str2) System.out.println("str1 == str2");
        else System.out.println("str1 != str2");

        if(str1.equals(str2)) System.out.println("str1.equals str2");
        else System.out.println("!str1.equals str2");
    }

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkCompare();
    }
}
~~~

#### 실행결과

>str1 == str2 <br>
str1.equals str2

이전에 객체는 equals 로 비교해야한다고 언급한 적이 있다. 그런데 == 연산자도 결과가 같은 이유는 
Constant Pool 이라는 것이 존재하기 때문인데 간단하게 설명하면 자바에서는 객체들을 재사용하기 위해서 Constant Pool 이라는 것이 만들어져 있고,
String 클래스 경우 동일한 값을 갖는 객체가 있으면 , 이미 만든 객체를 재사용 한다. <br>
즉, str1 ,str2 는 같은 객체라는 것이다. 

위의 [코드](#check)에서 수정해보자.
~~~java
String str1 = "Check";
String str2 = new String("Check");
~~~

#### 실행결과

> str1 != str2 <br>
str1.equals str2

이렇게 String 객체를 생성하면 값이 같은 String 객체를 생성한다고 하더라도 Constant Pool의 값을 재활용하지 않고 별도의 객체를 생성한다.

compareTo() 메소드는 정렬을 할 때 사용한다. 그렇기 때문에 boolean 값이 아닌 int 형 값을 반환한다.

위의 [코드](#check)에서 해당 부분을 추가해보자.

#### <div id = "compare"> compareTo </div>

~~~java
public void checkCompareTo() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "c";

        System.out.println(str1.compareTo(str2));
        System.out.println(str1.compareTo(str3));
        System.out.println(str2.compareTo(str1));
        }
~~~

#### 실행결과

>-1 <br>
-2 <br>
1

알파벳 순서대로 비교값이 자신의 순서보다 앞쪽(<-)인 경우 양수를 리턴하고 , 뒤쪽(->)인 경우 음수를 리턴한다. <br>
동일한 값인 경우에는 0을 리턴한다.

---