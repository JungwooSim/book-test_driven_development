# 부록 A - Junit5 추가 내용 
- @EnableOnOs, @DisabledOnOs
    - 특정 운영체제에서만 실행
- @EnableOnJre, @DisabledOnJre
- @EnabledIfSystemProperty, @DisabledIfSystemProperty
- @EnabledIfEnvironmentVariable, @DisabledIfEnvironmentVariable
- @TempDir
    - 임시 폴더 생성 후 테스트가 끝나면 삭제
- @Timeout
    - 테스트 메서드가 특정 시간내에 실행되는지 검증
