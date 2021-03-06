# 테스트 코드와 유지보수

### 테스트 코드 작성시 유의사항

- 변수나 필드를 사용해서 기댓값 표현하지 않기
    - 코드의 가독성이 좋아져서 테스트 코드를 더욱 쉽게 파악할 수 있다.

    ```java
    1. Example
    assertEquals(respondentId, savedAnswer.getRespondentId()); -> assertEquals(1, savedAnswer.getRespondentId());
    ```

- 두 개 이상을 검증하지 않기
- 정확하게 일치하는 값으로 모의 객체 설정하지 않기
    - 모의 객체는 가능한 범용적인 값을 사용해서 기술해야 한다. 한정된 값에 일치하도록 모의 객체를 사용하면 약간의 코드 수정만으로도 테스트는 실패하게 된다.

    ```java
    1. Example
    BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")) -> BDDMockito.given(mockPasswordChecker.checkPasswordWeak(Mockito.anyString()))
    ```

- 과도하게 구현 검증하지 않기
    - 테스트 대상의 내부 구현을 검증하는 것을 과도하게 하면 안된다.
      테스트 코드를 작성하는 이유는 실행 결과를 검증하는 것이다.
      내부 구현을 과도하게 검증하다보면 내구 구현 로직이 조금의 변경에도 테스트 코드가 깨질수 있다.
- 셋업을 이용해서 중복된 상황을 설정하지 않기
    - 셋업 메서드를 이용해서 여러 메서드에 동일한 상황을 적용하는 것이 처음에는 편리할 수 있다.
      하지만 시간이 지날수록 테스트 코드를 이해하고 유지보수 하는데 오히려 방해가 될 수 있다.
      테스트 메서드는 자체적으로 검증하는 내용을 완전히 기술하고 있어야 테스트 코드를 유지보수하는 노력을 줄일 수 있다.
- 통합 테스트에서 데이터 공유 주의하기
- 실행 환경이 다르다고 실패하지 않기
- 실행 시점이 다르다고 실패하지 않기
- 랜덤하게 실패하지 않기
- 필요하지 않은 값은 설정하지 않기
- 단위 테스트를 위한 객체 생성 보조 클래스
- 조건부로 검증하지 않기
- 통합 테스트는 필요하지 않은 범위까지 연동하지 않기
- 더 이상 쓸모 없는 테스트 코드
