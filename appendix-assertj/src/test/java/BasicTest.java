import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BasicTest {

    @Test
    void sumTest() {
        int value = this.sum(2, 2);
        assertThat(value).isEqualTo(4);
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
