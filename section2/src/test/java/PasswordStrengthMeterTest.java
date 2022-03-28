import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordStrengthMeterTest {
    /**
     * 검사할 규칙
     * - 길이가 8글자 이상
     * - 0 부터 9 사이의 숫자를 포함
     * - 대문자 포함
     * - 세 규칙을 모두 충족하면 암호는 강함이다
     * - 2개의 규칙을 충족하면 암호는 보통이다
     * - 1개 이하의 규칙을 충족하면 암호는 약함이다
     */

    @Test
    void name() {

    }

    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result);
        PasswordStrength result2 = meter.meter("ab12!@Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }
}
