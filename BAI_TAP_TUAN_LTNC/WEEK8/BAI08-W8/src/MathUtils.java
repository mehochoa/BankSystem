/**
 * max
 * EP1 (a > b): a=5, b=2 -> 5
 * EP2 (a = b): a=5, b=5 -> 5
 * EP3 (a < b): a=1, b=4 -> 4
 * BVA1 (MAX): a = Integer.MAX_VALUE, b = 0 -> Integer.MAX_VALUE
 * BVA2 (MIN): a = MIN, b = -1 -> -1
 * BVA3 (MIN + MAX): a = MIN, b = MAX -> MAX
 *
 * divide
 * EP1 (b > 0): a = 10, b = 2 -> 5
 * EP2 (b = 0): a = 10, b = 0 -> IllegalArgumentException
 * EP3 (b < 0): a = 10, b = -2 -> -5
 */

public class MathUtils {
    public static int max(int a, int b) {
        if (a >= b) return a;
        return b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divider must not be zero");
        }
        return a / b;
    }
}