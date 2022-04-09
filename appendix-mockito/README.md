# 부록 C - Mockito 기초 사용법
### 모의 객체 생성

```java
Mockito.mock() 메서드는 클래스, 인터페이스, 추상 클래스에 대해 모의 객체를 생성할 수 있다.
EX.
GameNumGen genMock = mock(GameNumGen.class);
```

### 스텁 설정

BDDMockito.given() 메서드를 이용하면 모의 객체의 메서드가 특정 값을 리턴하도록 설정할 수 있다.

<img src="/img/4.png" width="1000px;">

### 인자 매칭 처리

> Mockito 는 일치하지 않는 스텁 설정이 없을 경우 리턴 타입의 기본 값을 리턴한다.</br>
예를 들어, 리턴 타입이 int 면 0 을 리턴하고 boolean 이면 false 를 리턴한다.</br>
기본 데이터 타입이 아닌 String 이나 List 와 같은 참조 타입이면 null 을 리턴한다.</br>
>

```java
@Test
void anyMatchTest() {
    GameNumGen genMock = mock(GameNumGen.class);
    given(genMock.generate(any())).willReturn("456");

    String num = genMock.generate(GameLevel.EASY);
    assertEquals("456", num);

    String num2 = genMock.generate(GameLevel.NORMAL);
    assertEquals("456", num2);
}
```

`org.mockito.ArgumentMatchers` 클래스를 사용하면 정확하게 일치하는 값 대신 임의의 값에 일치하도록 설정할 수 있다.

- 기본 데이터 타입에 대한 임의 값 일치
    - anyInt(), anyShort(), anyLong(), 등
- 문자열에 대한 임의 값 일치
    - anyString()
- 임의 타입에 대한 일치
    - any()
- 임의 컬렉션에 대한 일치
    - anyList(), anySet(), anyMap(), anyCollection()
- 정규표현식을 이용한 String 값 일치 여부
    - matches(String), matches(Pattern)
- 특정 값 일치 여부
    - eq(값)

```java
Mockito 는 한 인자라도 ArgumentMatchers 를 사용해서 설정한 경우 모든 인자를 ArgumentMatchers 를 이용해서 설정하도록 하고 있다

@Test
void mixAnyAndEq() {
    List<String> mockList = mock(List.class);

    given(mockList.set(anyInt(), eq("123"))).willReturn("456");

    String old = mockList.set(5, "123");
    assertEquals("456", old);
}
```

### 행위 검증

모의 객체의 역할 중 하나는 실제로 모의 객체가 불렸는지 검증하는 것이다.

```java
@Test
    void init() {
        GameNumGen genMock = mock(GameNumGen.class);
        Game game = new Game(genMock);
        game.init(GameLevel.EASY);

        then(genMock).should().generate(GameLevel.EASY);
        then(genMock).should(only()).generate(GameLevel.EASY); // 정확하게 한 번만 호출된 것을 검증
    }
```

메서드 호출 횟수를 검증하기 위해 Mockito 클래스가 제공하는 메서드

- only() : 한번만 호출
- times(int) : 지정한 횟수만큼 호출
- never() : 호출하지 않음
- atLeast(int) : 적어도 지정한 횟수만큼 호출
- atLeastOnce() : atLeast(1) 과 동일
- atMost(int) : 최대 지정한 횟수만큼 호출

### 인자 캡처

단위 테스트를 실행하다보면 모의 객체를 호출할 때 사용한 인자를 검증해야할 때가 있는데 이를 도와주는것이 인자 캡처이다.

```java
@DisplayName("가입하면 메일을 전송함")
@Test
void whenRegisterThenSendMail() {
    userRegister.register("id", "pw", "email@email.com");

    // ArgumentCaptor 는 모의 객체의 메서드를 호출 할 때 전달한 객체를 담는 기능
    ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    BDDMockito.then(mockEmailNotifier)
            .should().sendRegisterEmail(captor.capture());

    String realEmail = captor.getValue();
    assertEquals("email@email.com", realEmail);
}
```

### JUnit5 확장 설정

mockito-junit-jupiter 의존을 추가 후 사용 가능하다.

```java
@ExtendWith(MockitoExtension.class)
public class JUnit5ExtensionTest {
    @Mock
    private GameNumGen genMock;
}
```
