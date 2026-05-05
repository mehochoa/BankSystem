import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên tệp: ");
        String fileName = sc.nextLine();
        //mở luồng để ghi dữ liệu nguyên thủy
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))){
            System.out.print("Nhập số lượng số nguyên n: ");
            int n = sc.nextInt();
            for (int i = 0; i < n; i++){
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                dos.writeInt(sc.nextInt());  //đọc số nguyên từ bàn phím và ghi giá trị nhị phân của nó vào tệp
            }
        }catch(IOException e){
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }

        System.out.println("--- Đang đọc dữ liệu từ tệp ---");
        //mở luồng để đọc dữ liệu từ tệp đã lưu
        try(DataInputStream dis = new DataInputStream(new FileInputStream(fileName))){
            while (true){
                System.out.println(dis.readInt());
            }
        }catch(EOFException e){  //báo dừng việc đọc
            System.out.println("Đã đọc hết dữ liệu.");
        }catch(IOException e){
            System.out.println("Lỗi I/O: " + e.getMessage());
        }
    }
}