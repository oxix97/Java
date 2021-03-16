# 자바의 신

---

### 특정 조건에 맞는 문자열이 있는지 확인하는 메소드

가장 많이 사용하는 것이 startWith() 라는 함수이다. <br>
startWith() 메소드는 이름 그대로 매개 변수로 넘겨준 값이 시작하는지를 확인한다. <br>
indexOf()라는 메소드를 사용하여 확인하는 것도 가능하지만, 해당 메소드의 단점은 문자열의 모든 내용을 다 확인해 봐야 한다는 단점이 있다. <br>
startWith(), endWith() 메소드는 startWith("서울") 이라고 하면 "서울"의 주소를 갖는 모든 문자열을 쉽게 찾을 수 있다.

#### <div id = "start"> startWith </div>

~~~java
public class Checkable {

    public static void main(String[] args) {
        Checkable checkable = new Checkable();

        String[] address = {"서울 구로구 고척동", "경기도 화성시 양산동", "서울 구로구 개봉동"};

        checkable.checkAddress(address);
    }

    public void checkAddress(String[] address) {
        int begin = 0, end = 0;

        String beginStr = "서울";
        String endStr = "동";

        for (String str : address) {
            if (str.startsWith(beginStr)) ++begin;

            if (str.endsWith(endStr)) ++end;
        }
        System.out.println("Starts with " + beginStr + " count is " + begin);
        System.out.println("Ends with " + endStr + " count is " + end);
    }
}
~~~

#### 실행결과

>Starts with 서울 count is 2 <br>
Ends with 동 count is 3

서울로 시작하는 문자열은 2개, 동으로 끝나는 문자열은 3개가 있는 것을 확인할 수 있다.

그렇다면 중간에 있는 문자열은 어떻게 확인 가능할까?? <br>
matches() , contains() 메소드를 사용하면 가능하다 matches() 같은 경우 정규표현식으로 되어 있어야만 한다. <br>
정규 표현식이란? 이메일, 웹 페이지의 URL 등 점검하는 등의 작업을 쉽게 하기 위해 공식에 따라 만든 식이다.

위의 [코드](#start)에서 해당 부분만 추가해보자.
~~~java
int mid = 0;
String midStr = "구로";
if(str.contains(midStr)) ++mid;
~~~

#### 실행결과

>Contains 구로 count is 2

---
### String 내에서 위치를 찾아내는 방법

String 클래스에서 indexOf 라는 단어가 포함되어 있는 메소드를 제공한다.
해당 객체의 특정 문자열이나 char 가 있는 위치를 알 수 있으며 없는 경우에는 -1을 리턴한다.

indexOf() 메소드는 String 클래스에서 많이 사용되는 메소드 이며 그 중에서 indexOf(), lastIndexOf() 이 두가지로 나뉜다.

#### <div id = "index"> indexOf() </div>
~~~java
public class Checkable {

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkIndexOf();
    }

    public void checkIndexOf() {
        String str = "Java Programming is funny";
        System.out.println(str.indexOf('m')); // 1
        System.out.println(str.indexOf("m")); // 2
        System.out.println(str.indexOf('m', 20)); //3
        System.out.println(str.indexOf("m", 20)); //4
        System.out.println(str.indexOf('z')); //5
    }
}
~~~

#### 실행결과

>11 <br>
11  <br>
-1 <br>
-1 <br>
-1

indexOf는 왼쪽부터 시작하며 오른쪽 맨 끝을 마지막으로 탐색한다.
int를 매개 변수로 갖는 메소드는 char 역시 정수형이기 때문에 형변환이 가능하다. <br>
1,2 의 경우 자료형이 달라고 같은 값으로 나왔다. <br>
3,4의 경우 20번째 부터 자리 값을 확인하기 때문에 해당 값을 찾지 못해 -1 을 반환하였다.
5의 경우 마찬가지로 값을 찾지 못하여 -1을 반환하였다.

lastIndexOf의 경우는 indexOf 와 다 똑같지만 가장 우측을 시작하여 가장 왼쪽을 마지막으로 탐색한다.

위의 [코드](#index)에 해당 메소드를 추가해보자.
~~~java
public void checkLastIndexOf() {
    String str = "Java Programming is funny";
        
    System.out.println(str.lastIndexOf('m'));
    System.out.println(str.lastIndexOf("m"));
    System.out.println(str.lastIndexOf('m', 20));
    System.out.println(str.lastIndexOf("m", 20));
    System.out.println(str.lastIndexOf('z'));
}
~~~

#### 실행결과

> 12 <br>
12 <br>
12 <br>
12 <br>
-1

indexOf, lastIndexOf 서로 시작위치와 방향만 다르고 나머지는 다 똑같다.

---
### String 값의 일부를 추출하는 메소드

#### 값을 추출하는 메소드의 종류

- char 단위의 값을 추출하는 메소드
- char 배열의 값을 String으로 변환하는 메소드
- String 나누는 메소드 의 값을 char 배열로 변환하는 메소드

char 단위의 값을 추출하는 메소드는 대표적으로 charAt(int index) 이 있으며 한글의 경우에는 한 글자로 인식한다.

char 배열의 값을 String 으로 변환하는 메소드는 copyValueOf(char[] data) 인데 잘 사용되지 않는다.

String 의 값을 char 배열로 변환하는 메소드는 toCharArray() 이며 String s = "Java" -> char[] str = {"J" ,"a" ,"v","a"}; 이렇게 변환시켜준다.

----
#### 문자열의 일부 값을 잘라내는 메소드

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
|:---|:---|:---|
| String | substring(int beginIndex) | beginIndex 부터 끝까지 대상 문자열을 잘라 String 으로 리턴한다. |
| String | substring(int beginIndex, int endIndex) | beginIndex 부터 endIndex 까지 대상 문자열을 잘라 String 으로 리턴한다. |
| CharSequence | subSequence(int beginIndex, int endIndex) | beginIndex 부터 endIndex 까지 대상 문자열을 잘라 CharSequence 타입으로 리턴한다. ||

---
#### 문자열 여러 개의 String 배열로 나누는 split 메소드

~~~java
public void checkSplit() {
    String str = "You know I can paint the world sitting there in black and gold";
    String[] arr = str.split(" ");

    for (String temp : arr) {
        System.out.println(temp);
    }
}
~~~

#### 실행결과

> You <br>
know <br>
I <br>
can <br>
paint <br>
the <br>
world <br>
sitting <br>
there <br>
in <br>
black <br>
and <br>
gold

str 에 있는 문자열을 공백으로 나누어 arr 배열에 담고 출력한 결과이다.

---
### String 값을 바꾸는 메소드

#### 문자열 공백을 없애는 메소드

trim() 이라는 메소드인데 문자열의 맨 앞과 맨 뒤에 있는 공백들을 제거한 문자열 객체를 리턴해준다.

~~~java
public class Checkable {

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkTrim();
    }

    public void checkTrim() {
        String[] strs = {" a", "b ", "  ,", "  c", "d    "};

        for (String str : strs) {
            System.out.println("[" + str.trim() + "] ");
        }
    }
}
~~~

#### 실행결과

> [a] <br>
[b] <br>
[,] <br>
[c] <br>
[d]  

trim() 메소드를 사용하여 공백이 제거된 모습을 확인할 수 있다.

---
#### replace 메소드

해당 메소드는 문자열에 있는 내용 중 일부를 변경하는 작업을 수행한다고 해서 기존 문자열의 값이 바뀌지는 않는다.

| 리턴 타입 | 메소드 이름 및 매개 변수 | 설명 |
|:---|:---|:---|
| String | replace(char oldChar , char newChar) | 해당 문자열에 있는 oldChar 의 값을 newChar 로 대치한다. |
| String | replace(CharSequence target, CharSequence replacement) | 해당 문자열에 있는 target 과 같은 값을 replacement 로 대치한다. |
| String | replaceAll(String regex, String replacement) | 해당 문자열의 내용 중 regex 에 표현된 정규 표현식에 포함되는 모든 내용을 replacement 로 대치한다. |
| String | replaceFirst(String regex, String replacement) | 해당 문자열의 내용 중 regex 표현된 정규 표현식에 포함되는 첫번째 내용을 replacement 로 대치한다. |

~~~java
public class Checkable {

    public static void main(String[] args) {
        Checkable checkable = new Checkable();
        checkable.checkReplace();
    }

    public void checkReplace() {
        String str = "You know I can paint the world sitting there in black and gold";

        System.out.println(str.replace('a', 'A')); // 1
        System.out.println(str.replace("You", "WE")); // 2
        System.out.println(str.replaceAll(" ", "/")); // 3
        System.out.println(str.replaceFirst(" ", "/")); //4
    }
}
~~~

#### 실행결과

> You know I cAn pAint the world sitting there in blAck And gold <br>
WE know I can paint the world sitting there in black and gold <br>
You/know/I/can/paint/the/world/sitting/there/in/black/and/gold <br>
You/know I can paint the world sitting there in black and gold

---
### 정리해봅시다.

- 자바의 String 클래스는 final 로 선언되어 있으며, 확장이 불가하다.
- String 클래스의 getBytes()는 문자의 바이트 배열로 전환한다.
- String 객체의 메소드를 확인하기 전에 null check 를 해야하는 습관을 가져야한다.
- length() 메소드는 문자열의 길이를 알 수 있다.
- equals, compareTo 공통점은 두 개의 문자열을 비교한다는 것이며, 다른점은 리턴 타입이 boolean, int 타입이기 때문에 쓰임새가 다르다.
- startsWith() 메소드를 사용하면 해당 문자열로 시작하는지 확인가능하며 , endsWith() 메소드는 해당 문자열로 마치는지 확인가능하다.
- contains(), matches() 메소드는 해당 문자열이 포함되는지 확인가능하다
- substring(), subSequence() 메소드를 사용하면 문자열을 자를 수 있다.
- replace(), replaceAll() 메소드를 사용하면 문자열의 특정 부분 변경 가능하지만, 기존 문자열은 변경되지 않아 변경한 값을 사용하려면 리턴값을 사용해야 한다.

