import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileTest {

    @Test
    void noDataFile_Then_Exception() {
        givenNoFile("badpath.txt");

        File dataFile = new File("badpath.txt");
        assertThrows(IllegalArgumentException.class,
                () -> MathUtils.sum(dataFile)
        );
    }

    /**
     * 파일이 없다는걸 100% 확신하기 위해 명시적으로 작성
     */
    private void givenNoFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            boolean delete = file.delete();
            if (!delete)
                throw new RuntimeException("fail givenNoFile: " + path);
        }
    }
}
