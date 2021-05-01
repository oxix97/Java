# 자바의 신

### 목차

- [Generic](#Generic)
- [Generic 규칙](#제네릭-타입의-이름)
- [제네릭에 ? 사용](#제네릭에-?-사용)



### Generic

제네릭은 타입 형 변환에서 발생할 수 있는 문제점을 사전에 없애기 위해서 만들어졌다. 
여기서 사전이라고 하는 것은 실행시에 예외가 발생하는 것을 처리하는 것이 아니라 컴파일할 때 
점검할 수 있도록 한 것을 의미한다. 어떻게 사용하는지 확인해보자.

#### 제네릭 미사용

~~~java
package Generic;

import java.io.Serializable;
public class CastingDTO implements Serializable {
    private Object object;

    public void setObject(Object o) {
        this.object = o;
    }

    public Object getObject() {
        return object;

    }
}
~~~

Object로 타입이 되어있어 어떤 타입이던 사용이 가능하다.

#### 제네릭 사용

~~~java
package Generic;

import java.io.Serializable;

public class CastingGenericDTO<T> implements Serializable {
    private T object;

    public void setObject(T o) {
        this.object = o;
    }

    public T getObject() {
        return object;

    }
}
~~~

제네릭 미사용과 다른점은 Object 대신 T 를 사용하였고 클래스 선언문의 <T>의 유무이다. 
여기서 T는 아무런 이름이나 지정햇도 컴파일하는 데 문제 없다.

<>안에 선언한 이름은 클래스 안에서 하나의 타입 이름처럼 사용하면 된다. 가상의 타입 이름이라고 생각하면 된다.

~~~java
package Generic;

public class GenericSample {
    public static void main(String[] args) {
        GenericSample sample = new GenericSample();
        sample.checkGenericDTO();
    }

    public void checkGenericDTO (){
        CastingGenericDTO<String> dto1 = new CastingGenericDTO<>();
        dto1.setObject(new String());

        CastingGenericDTO<StringBuffer> dto2 = new CastingGenericDTO<>();
        dto2.setObject(new StringBuffer());

        CastingGenericDTO<StringBuilder> dto3 = new CastingGenericDTO<>();
        dto3.setObject(new StringBuilder());
        
        String temp1 = dto1.getObject();
        StringBuffer temp2 = dto2.getObject();
        StringBuilder temp3 = dto3.getObject(); 
    }
}
~~~

해당 소스는 형 변환을 할 필요가 없다. 제네릭 타입이 아닌 타입으로 치환하면 컴파일 자체가 안 된다.
따라서, 실행시에 다른 타입으로 잘못 형 변환하여 예외가 발생하는 일은 없다.
이와 같이 명시적으로 타입을 지정할 때 사용하는 것이 제네릭이다.

---
### 제네릭 타입의 이름

자바에서 정의한 기본 규칙은 다음과 같다.

- E : 요소
- K : 키
- N : 숫자
- T : 타입
- V : 값
- S,U,V : 두 번째, 세 번째, 네 번째에 선언된 타입

---
### 제네릭에 ? 사용

정해진 타입을 사용하는 제네릭한 객체를 생성하고 메소드를 이용하여 결과를 출력하는데 만약 다른 타입으로 선언된 객체를 받으려면 어떻게 해야 할까??

~~~java
public void wildcardStringMethod(WildcardGeneric<?> c){
    Object value = c.getWildcard();
    System.out.println(value);
}
~~~

<>안에 타입 대신 ? 를 적어주면 어떤 타입이 제네릭 타입이 되더라도 상관 없다. 그렇지만,
메소드 내부에서는 해당 타입을 정확히 모르기 때문에 Object로 처리해야만 한다. ?로 명시한 타입을 영어로는 wildcard 타입이라고 한다.
이러한 wildcard는 메소드의 매개 변수로만 사용하는 것이 좋다. 예를 들어 확인해 보자

~~~java
public void callWildcardMethod(){
    WildcardGeneric<?> wildcard = new WildcardGeneric<String>();
    wildcard.setWildcard("A");
    wildcardStringMethod(wildcard);
}
~~~

이와 같이 사용한다면 알 수 없는 타입에 String을 저장할 수 없다는 에러 메세지가 나오게 된다.
다시말해, 어떤 객체를 wildcard로 선언하고, 그 객체의 값은 가져올 수 있지만, 와일드 카드로 객체를 선언했을 경우 특정 타입으로 값을 지정하는 것은 불가능하다.

---
### 제네릭 범위 설정

제네릭을 사용할 때 <> 안에는 어떤 타입이 와도 상관없지만 ?로 사용하는 경우 타입을 제한할 수 있다
? 대신 ? extends 타입으로 선택하면 된다.

~~~java

~~~











