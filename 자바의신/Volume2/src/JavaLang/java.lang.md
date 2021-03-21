# 자바의 신

---
### java.lang

java.lang 패키지는 특별한 패키지이다. 그 이유는 유일하게 java.lang 패키지에 있는 클래스들은 import 하지 않아도 사용이 가능하다.
그만큼 자바에서 필수적인 여러 기능들을 제공한다는 의미다. java.lang, java.util 패키지를 제외한 대부분의 java 로 시작하는 패키지들은
이름만 보고도 어떤 일을 할 때 사용하는지 알수 있지만 java.lang, java.util 같은 경우 유추하기 힘드며 다양한 기능들로 구성되어 있다.

#### java.lang 패키지에서 제공하는 인터페이스, 클래스, 예외 클래스 등은 다음과 같이 분류된다.

- 언어 관련 기본
- 문자열 관련
- 기본 자료형 및 숫자 관련
- 쓰레드 관련
- 예외 관련
- 런타임 관련

---
#### java.lang interface

- Cloneable
- Comparable
- Iterable
- Readable

---
#### java.lang class

- Class
- ClassLoader
- Compiler
- Enum
- Object
- Package
- SecurityManager
- StackTraceElement
- System
- void

---
#### java.lang exception , error

- java.lang <br>
- ReflectiveOperationException <br>
- ClassNotFoundException <br>
- InstantiationException <br>
- IllegalAccessException <br>
- InvocationTargetException <br>
- NoSuchFieldException <br>
- NoSuchMethodException <br>
- CloneNotSupportedException <br>
- InterruptedException <br>
- 산술 예외 <br>
- IndexOutOfBoundsException <br>
- ArrayIndexOutOfBoundsException <br>
- StringIndexOutOfBoundsException <br>
- ArrayStoreException <br>
- ClassCastException <br>
- EnumConstantNotPresentException <br>
- IllegalArgumentException <br>
- IllegalThreadStateException <br>
- NumberFormatException <br>
- IllegalMonitorStateException  <br>
- IllegalStateException <br>
- NegativeArraySizeException <br>
- NullPointerException <br>
- SecurityException <br>
- TypeNotPresentException <br>
- UnsupportedOperationException <br>

---

당연히 모든 클래스와 인터페이스, 예외를 알아야 하는 것은 아니지만 어느정도는 알고 있어야한다.
 
에러 역시 모두 알 필요가 없지만 중요한 부분은 알아야 한다. 예를 들면 
OutOfMemoryError(OOME)와 StackOverflowError는 알고 있어야한다.

OOME 같은 경우 자바는 가상 머신에서 메모리를 관리하지만, 프로그램을 잘못 작성하거나 설정이 제대로 되어 있지 않은 경우에 
이런 에러가 발생할 수있다.

StackOverflowError 같은 경우 호출된 메소드의 깊이가 너무 깊을 때 발생한다. 
자바에서는 스택이라는 영역에 어떤 메소드가 어떤 메소드를 호출 했는지에 대한 정보를 관리한다. <br>
메소드가 자기 자신을 호출하는 재귀 메소드를 잘못 작성했다면 스택에 쌓을 수 있는 메소드 호출 정보의 한계를 넘어설 수 있다.

---