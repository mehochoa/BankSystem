import java.io.*;
import java.util.Scanner;

public class Main{
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đường dẫn tệp nguồn: ");
        String sourcePath = sc.nextLine();
        System.out.println("Nhập đường dẫn tệp đích: ");
        String destPath = sc.nextLine();

        BufferedReader reader = null;
        PrintWriter writer = null;
        int lineCount = 0;
        try{
            //thiết lập luồng đọc và ghi
            reader = new BufferedReader(new FileReader(sourcePath));
            writer = new PrintWriter(new FileWriter(destPath));

            String line;
            while ((line = reader.readLine()) != null){
                writer.println(line);
                lineCount++;
            }
            System.out.println("Sao chép thành công! Tổng số dòng đã sao chép: " + lineCount);
        }catch (FileNotFoundException e){
            //Lỗi này xảy ra khi đường dẫn sourcePath không tồn tại trên ổ cứng
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()){
                System.out.println("Source file not found.");
            }else{
                //Nếu file nguồn có thật mà vẫn lỗi, thì là do không tạo được file đích (destPath)
                System.out.println("Cannot create destinantion file.");
            }
        }catch (IOException e){
            //Lỗi chung về đọc/ghi dữ liệu (ví dụ: ổ cứng bị rút ra đột ngột, hết dung lượng...)
            System.out.println("I/O error.");
            e.printStackTrace(); //In ra các dòng code bị lỗi
        }finally{
            try{
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            }catch (IOException e){
                System.out.println("Error closing file.");
            }
        }
    }
}