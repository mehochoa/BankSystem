/**
 * EP1: gpa < 0.0 (-5.0) -> Ném IllegalArgumentException
 * EP2: 0.0 <= gpa < 5.0 (3.0) -> "Yếu"
 * EP3: 5.0 <= gpa < 6.5 (6.0) -> "Trung bình"
 * EP4: 6.5 <= gpa < 8.0 (7.0) -> "Khá"
 * EP5: 8.0 <= gpa <= 10.0 (9.0) -> "Giỏi"
 * EP6: gpa > 10.0 -> Ném IllegalArgumentException
 *
 * Biên 0.0: -0.1 (Exception), 0.0 ("Yếu"), 0.1 ("Yếu")
 * Biên 5.0: 4.9 ("Yếu"), 5.0 ("Trung bình"), 5.1 ("Trung bình")
 * Biên 6.5: 6.4 ("Trung bình"), 6.5 ("Khá"), 6.6 ("Khá")
 * Biên 8.0: 7.9 ("Khá"), 8.0 ("Giỏi"), 8.1 ("Giỏi")
 * Biên 10.0: 9.9 ("Giỏi"), 10.0 ("Giỏi"), 10.1 (Exception)
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {
    // --- EP ---
    @Test
    public void testEP_Yeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
    }

    @Test
    public void testEP_TrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }

    @Test
    public void testEP_Kha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    public void testEP_Gioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
    }

    // --- BVA ---
    @Test
    public void testBVA_Bound0() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.1));
    }

    @Test
    public void testBVA_Bound5() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0)); // expect: TB, received: Yeu
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.1));
    }

    @Test
    public void testBVA_Bound6_5() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.4));
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5)); // expect: Kha, received: TB
        assertEquals("Khá", GradeClassifier.classifyGrade(6.6));
    }

    @Test
    public void testBVA_Bound8() {
        assertEquals("Khá", GradeClassifier.classifyGrade(7.9));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.1));
    }

    @Test
    public void testBVA_Bound10() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.9));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }

    @Test
    public void testException_GpaBelowZero() {
        double invalidGpa = -0.1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(invalidGpa)
        );
        assertEquals("GPA không hợp lệ: -0.1", exception.getMessage());
    }

    @Test
    public void testException_GpaAboveTen() {
        double invalidGpa = 10.1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> GradeClassifier.classifyGrade(invalidGpa)
        );
        assertEquals("GPA không hợp lệ: 10.1", exception.getMessage());
    }
}
