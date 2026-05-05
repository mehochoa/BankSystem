public class Solution4 {
    public static boolean isPalindrome(int n) {
        if (n < 0) return false;
        if (n % 10 == 0 && n != 0) return false;
        int origin = n;
        int reverse = 0;
        while (n != 0){
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }
        return origin == reverse;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(100));
    }
}
