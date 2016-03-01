import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by thierry on 16/02/2016.
 */
public class SimpleTest {

    @BeforeClass
    public void setUp() {

    }

    @Test(description = "Test addition operation")
    public void test1() {
        System.out.println("Test 1");
        assert 2 == (1 + 1) : "Value expected !";
    }

    @Test(description = "Test subtraction operation")
    public void test2() {
        System.out.println("Test 2");
        assert 1 == (2 - 1) : "Value expected !";
    }
}
