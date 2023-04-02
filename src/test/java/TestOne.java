import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("report")
public class TestOne {
    @Test
    void test1(){
        Assertions.assertTrue(true);
    }

    @Test
    void test2(){
        Assertions.assertTrue(false);
    }


}
