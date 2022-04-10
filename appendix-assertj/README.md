# 부록 D - AssertJ 소개
JUnit 은 테스트 실행을 위한 프레임워크를 제공하지만 단언에 대한 표현력이 부족하다는 단점이 있다. 이러한 점을 보완하기 위해 AssertJ 를 사용 한다.

### 거의 모든 타입에 사용할 수 있는 검증 메서드

isEqualTo() 를 포함하여 거의 모든 타입에 사용할 수 있는 검증 메서드

- isEqualTo(expected) : 값과 같은지 검증
- isNotEqualTo(expected) : 값과 같지 않은지 검증
- isNull() : null 인지 검증
- isNotNull() : null 이 아닌지 검증
- isIn(expected) : 값 목록에 포함되어 있는지 검증
- isNotIn(expected) : 값 목록에 포함되어 있지 않은지 검증

### Comparable 인터페이스를 구현한 타입이나 int, double 과 같은 숫자 타입의 경우

- isLessThan(value) : 값보다 작은지 검증
- isLessThanOrEqualTo(value) : 값보다 작거나 같은지 검증
- isGreaterThan(value) : 값보다 큰지 검증
- isGreaterThanOrEqualTo(value) : 값보다 크거나 같은지 검증
- isBetween(value1, value2) : 값1 과 값2 사이에 포함되는지 검증

### Boolean, boolean 타입을 위한 검증 메서드

- isTrue() : 값이 true 인지 검증
- isFalse() : 값이 false 인지 검증

### String 타입을 위한 검증

특정 값을 포함하는지 검증

- contains(CharSequence... values) : 인자로 지정한 문자열들을 모두 포함하고 있는지 검증
- containsOnlyOnce(CharSequence sequence) : 해당 문자열을 딱 한번만 포함하는지 검증
- containsOnlyDigits() : 숫자만 포함하는지 검증
- containsWhitespaces() : 공백 문자를 포함하고 있는지 검증
- containsPattern(CharSequence regex) : 지정한 정규 표현식에 일치하는 문자를 포함 하는지 검증
- containsPattern(Pattern pattern) : 지정한 정규 표현식에 일치하는 문자를 포함 하는지 검증

특정 값을 포함하지 않는지 여부

- doesNotContain(CharSequence... values) : 인자로 지정한 문자열들을 모두 포함하고 있지 않은지 검증
- doesNotContainAnyWhitespaces() : 공백 문자를 포함하고 있지 않은지를 검증
- doesNotContainOnlyWhitespace() : 공백 문자만 포함하고 있지 않은지를 검증
- doesNotContainPattern(Pattern pattern) : 정규 표현식에 일치하는 문자를 포함하고 있지 않은지를 검증
- doesNotContainPattern(CharSequence pattern) : 정규 표현식에 일치하는 문자를 포함하고 있지 않은지를 검증

특정 문자열로 시작하거나 끝나는지 검증

- startWith(CharSequence prefix) : 지정한 문자열로 시작하는지 검증
- doesNotStartWith(CharSequence prefix) : 지정한 문자열로 시작하지 않는지 검증
- endsWith(CharSequence suffix) : 지정한 문자열로 끝나는지를 검증
- doesNotEndWith(CharSequence suffix) : 지정한 문자열로 끝나지 않는지를 검증

### 숫자에 대한 추가 검증 메서드

- isZero() / isNotZero() : 0 인지 또는 0 이 아닌지를 검증
- isOne() : 1인지 검증
- isPositive() / isNotPositive() : 양수인지 또는 양수가 아닌지를 검증
- isNegative() / isNotNegative() : 음수인지 또는 음수가 아닌지를 검증

### 날짜 / 시간에 대한 검증 메서드

```java
Ex.
LocalDateTime regDt = user.getRegDt();
assertThat(regDt).ifAfter(LocaldateTime.of());
```

- isBefore(값) : 값보다 이전인지 검증
- isBeforeOrEqualTo(값) : 값보다 이전이거나 같은지 검증
- isAfter(값) : 값보다 이후인지 검증
- isAfterOrEqualTo(값) : 값보다 이후이거나 같은지 검증

LocalDateTime, OffsetDateTime, ZonedDateTime 타입은 다음의 검증 메서드를 추가로 제공

- isEqualToIgnoringNanos(값) : 나노 시간을 제외한 나머지 값이 같은지 검증 (즉 초 단위까지 값이 같은지 검증)
- isEqualToIgnoringSeconds(값) : 초 이하 시간을 제외한 나머지 값이 같은지 검증 (즉 분 단위까지 값이 같은지 검증)
- isEqualToIgnoringMinutes(값) : 분 이하 시간을 제외한 나머지 값이 같은지 검증 (즉 시 단위까지 값이 같은지 검증)
- isEqualToIgnoringHours(값) : 시 이하 시간을 제외한 나머지 값이 같은지 검증 (즉 일 단위까지 값이 같은지 검증)

## Collection에 대한 검증 메서드

List, Set 등 Collection 에 대한 주요 검증 메서드

- hasSize(int extected) : 크기가 지정한 값과 같은지 검증
- contains(E ... values) : 지정한 값을 포함하는지 검증
- conatainsOnly(E ... values) : 지정한 값만 포함하는지 검증
- containsAny(E ... values) : 지정한 값 중 일부를 포함하는지 검증
- containsOnlyOnce(E ... values) : 지정한 값을 한번만 포함하는지 검증

Map을 위한 주요 검증 메서드

- containsKey(K key) : 지정한 키를 포함하는지 검증
- containsKey(K ... keys) : 지정한 키들을 포함하는지 검증
- containsOnlyKeys(K ... keys) : 지정한 키만 포함하는지 검증
- doesNotContainKeys(K ... keys) : 지정한 키들을 포함하지 않는지 검증
- containsValues(VALUE... values) : 지정한 값들을 포함하는지 검증
- contains(Entry<K, V> ... values) : 지정한 Entity<K,V> 를 포함하는지 검증

### 익셉션 관련 검증 메서드

```java
// 익셉션 발생 여부를 검증
asserThatThrownBy(() -> readFile(new File("nofile,txt")));

// 발생한 익셉션의 타입을 추가로 검증 - 1
asserThatThrownBy(() -> readFile(new File("nofile,txt")))
	.isInstanceOf(IOException.class);

// 발생한 익셉션의 타입을 추가로 검증 - 2
assertThatExceptionOfType(IOException.class)
	.isThrownBy(() -> {
		readFile(new File("nofile.txct"));
});

// 익셉션이 발생하지 않는 것을 검증
assertThatCode(() -> {
		readFile(new File("nofile.txct"));
}).doesNotThrowAnyException();
```

### SoftAssertions 로 모아서 검증하기

```java
SoftAssertions soft = new SoftAssertions();
soft.assertThat(1).isBetween(0,2);
soft.assertThat(1).isGreaterThan(2);
soft.assertThat(1).isLessThan(0);
soft.assertAll();

// 정적 메서드 사용
SoftAssertions.assertSoftly(soft -> {
	soft.assertThat(1).isBetween(0,2);
	soft.assertThat(1).isGreaterThan(2);
	soft.assertThat(1).isLessThan(0);
});
```

### as() 와 describedAs() 로 설명 달기

as() 메서드는 테스트에 설명을 붙일 때 사용한다.</br>
Ex1. assertThat(id).as(”ID 검사").isEqualTo(”abc”);</br>
Ex2. assertThat(id).as(”ID 검사 : %s", “abc”).isEqualTo(”abc”);</br></br>
as() 메서드 대신에 describedAs() 메서드를 사용하도 된다 (기능은 같음)</br>
