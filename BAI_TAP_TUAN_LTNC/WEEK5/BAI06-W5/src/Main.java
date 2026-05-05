import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Nhập vào số nguyên a: ");
            int a = sc.nextInt();
            System.out.print("Nhập vào số nguyên b: ");
            int b = sc.nextInt();
            int res = a/b;
            System.out.println("Kết quả phép chia " + a + " / " + b + " = " + res);
        } catch (InputMismatchException e){
            System.out.println("Lỗi: Bạn phải nhập vào một số nguyên.");
        } catch (ArithmeticException e){
            System.out.println("Lỗi: Không thể chia cho số 0.");
        } finally{
            System.out.println("Program finished.");
            sc.close();
        }
    }
}