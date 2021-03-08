# 자바의 신

---

### 클래 안의 클래스

자바에서는 클래스안에 클래스가 들어갈 수 있다. 이러한 클래스를 NestedClass 라고 하며 
해당 클래스가 쓰이는 가장 큰 이유는 코드를 간단하게 표현하기 위함이다. <br>
Nested 클래스는 자바 기반의 UI 처리를 할 때 사용자의 입력이나, 외부의 이벤트에 대한 처리를 하는 곳에서 가장 많이 사용된다.

Nested 클래스는 static nested 클래스와 내부 클래스로 나뉘며 차이점은 static 으로 선언되는지 여부의 차이가 있다.

#### Nested 클래스를 사용하는 이유

- 소스의 가독성과 유지보수성을 높이고 싶을 때
- 한 곳에서만 사용되는 클래스를 논리적으로 묶어서 처리할 필요가 있을 경우
- 캡슐화가 필요할 경우 (내부 구현을 감추고 싶을 때)

---
### static nested class

내부 클래스는 외부 클래스의 어떤 변수도 접근 가능하지만 static nested 클래스는 불가능하다. <br>
그 이유는 static 으로 선언하기 때문이다. 

####  <div id = "nested"> 예를 들면 </div>

~~~java
public class OutOfStatic {

    static class StaticNested {
        private int value = 0;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        System.out.println(OutOfStatic.class);
        System.out.println(StaticNested.class);
    }
}
~~~

#### 실행결과

> class OutOfStatic <br>
class OutOfStatic$StaticNested

Nested 클래스는 클래스 이름 뒤에 $ 기호를 붙인 후 이름이 나온다. <br>
$ 기호를 붙인다고 해서 객체가 만들어진 이후에도 $ 기호를 붙이는 것은 아니다. 똑같이 클래스 이름 뒤에 . 을 쓰면 된다.

**Q.** 앞에서 클래스를 묶기 위해 쓴다고 했는데 무슨 말인지 모르겠다. <br>
**A.** School , University 라는 클래스 모두 Student 라는 클래스가 필요한데 해당 내부의 객체로 만들면 용도가 보다 명확해 진다.

예를 들면

~~~java
public class University{
    static class Student {
        
    }
}
~~~

~~~java
public class School {
    static class Student{
        
    }
}
~~~

University.Student , School.Student 는 서로 다르게 사용할 수 있기 때문이다.

---
### 내부클래스

static nested 클래스와 다른점은 static 선언 이라고 앞서 말했다. 무슨 역할이 다르길래 구분 지어 놨을까??


위의 [코드](#nested)에서 static class -> class 로 된 것 말고는 달라진게 없다.
~~~java
public class InnerClassEx {
    public static void main(String[] args) {
        InnerClassEx ex = new InnerClassEx();
        ex.makeInnerObject();
    }

    public void makeInnerObject() {
        OutOfInner outOfInner = new OutOfInner();
        OutOfInner.Inner inner = outOfInner.new Inner();
        inner.setValue(123);
        System.out.println(inner.getValue());
    }
}
~~~
실행 결과도 동일하다.

두 예제의 차이점은 객체를 생성하는 방법에 차이가 있다. Inner 클래스의 객체를 생성하기 전에는 
먼저 Inner 클래스를 감싸고 있는 OutOfInner 클래스의 객체를 생성하고 생성한 것으로 호출 Inner 클래스 객체를 만들어 낼 수 있다.

**Q.** static nested 방식보다 복잡한데 왜 쓰는 거지? <br>
**A.** 내부 클래스를 만드는 이유가 위에서 캡슐화 때문이라고 했는데 다른 클래스에서 해당 클래스가 필요가 없을 경우에 내부 클래스를 만들어 사용한다.
그 이유는 하나의 별도 클래스를 만드는 것 보다 간단하기 때문이다.

내부 클래스 보다 더 간단한 방법이 있는데 이것을 **익명 클래스** 라고 한다.

#### <div id = "anonymous"> 익명 클래스 </div>

~~~java
public class AnonymousEx {
    public static void main(String[] args) {
        AnonymousEx ex = new AnonymousEx();
        ex.setButtonListener();
        ex.setButtonListenerAnonymous();
    }
    
    // 1번 방식
    public void setButtonListener() {
        ButtonClass button = new ButtonClass();
        button.setListener(new EventListener() {
            @Override
            public void onClick() {
                System.out.println("Button Clicked");
            }
        });
        button.onClickProcess();
    }
    
    // 2번 방식
    public void setButtonListenerAnonymous() {
        ButtonClass button = new ButtonClass();
        EventListener listener = new EventListener() {
            public void onClick(){
                System.out.println("Button Clicked");
            }
        };
        button.setListener(listener);
        button.onClickProcess();
    }
}
~~~

#### 실행결과

> Button Clicked <br>
Button Clicked

1번방식을 보면 new EventListener()로 생성자를 호출한 다음 바로 중괄호를 열어 onClick()을 구현하였다.
겉보기에는 클래스를 선언한 것이지만, 실제로 setListener() 메소드를 호출하는 과정 내에 익명 클래스가 있어 세미콜론으로 마무리 해 주어야 한다. <br>
1번 방식의 단점은 구현했을 때 이름도 없고 객체도 없어서 다른 클래스, 메소드에서 참조를 할 수 없어 재사용이 불가하다.

객체를 재사용 하려면 2번 방식으로 객체를 생성한 이후에 사용하면 된다.

클래스를 호출하면 메모리에 올라가게 되는데 클래스를 많이 만들면 당연히 메모리는 더 필요해 지고 시간도 많이 걸린다. <br>
이러한 현상을 조금이라도 줄이고자 간단한 방법으로 객체 생성할 수 있도록 해놓았으며 줄일 수 있으면 줄이는 것이 좋다.

---
### 정리해봅시다.

- Nested 클래스의 3가지는 Static nested, Inner , Anonymous Inner
- Nested 클래스를 컴파일 하면 Nested 클래스 파일의 이름은 $ 으로 시작한다.
- Static Nested 클래스와 다른 Nested 클래스의 차이 static 선언 유무
- StaticNested 클래스 객체 생성은 Outer.Inner = new Outer.Inner();
- 일반적인 내부 클래스 생성 방법은 내부 클래스를 감싸고 있는 클래스의 객체를 생성한 다음 그 객체를 통해 내부 클래스 객체를 만들 수 있다.