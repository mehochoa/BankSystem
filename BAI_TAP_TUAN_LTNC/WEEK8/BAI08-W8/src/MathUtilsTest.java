import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @BeforeAll
    public static void setUpBeforeClass() {
        System.out.println("=== Bắt đầu chạy MathUtilsTest ===");
    }

    @AfterAll
    public static void tearDownAfterClass() {
        System.out.println("=== Kết thúc ===");
    }

    /**
     * max
     */
    @Test
    public void testMax_aGreaterThanB() {
        assertEquals(5, MathUtils.max(5, 2));
    }

    @Test
    public void testMax_aEqualsB() {
        assertEquals(3, MathUtils.max(3, 3));
    }

    @Test
    public void testMax_aLessThanB() {
        assertEquals(4, MathUtils.max(1, 4));
    }

    @Test
    public void testMax_BoundaryValues() {
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, 0));
        assertEquals(-1, MathUtils.max(Integer.MIN_VALUE, -1));
        assertEquals(Integer.MAX_VALUE, MathUtils.max(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    /**
     * divide
     */
    @Test
    public void testDivide_positiveDivider() {
        assertEquals(5, MathUtils.divide(10, 2));
    }

    @Test
    public void testDivide_negativeDivider() {
        assertEquals(-5, MathUtils.divide(10, -2));
    }

    @Test
    public void testDivide_zeroDivider() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> MathUtils.divide(10, 0));
        assertEquals("Divider must not be zero", exception.getMessage());
    }
}
