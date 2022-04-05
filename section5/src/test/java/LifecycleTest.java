import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class LifecycleTest {

    @BeforeEach
    void setUp(){
        System.out.println("setUp");
    }

    @Test
    void a() {
        System.out.println("A");
    }

    @Disabled
    @Test
    void b() {
        System.out.println("B");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}
