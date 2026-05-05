import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("---Đang đo hiệu năng, vui lòng đợi ..... ---");
        useString();
        useStringBuffer();

        System.out.println("\n---Phân tích văn bản---");
        System.out.println("Nhập vào một đoạn văn bản: ");
        String vanBan = sc.nextLine();
        contentAnalysis(vanBan);
        sc.close();
    }

    public static void useString(){
        long startTime = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++){
            s+= "Hello";
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian dùng String: " + (endTime - startTime) + "ms");
    }

    public static void useStringBuffer(){
        long startTime = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++){
            sb.append("Hello");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Thời gian dùng StringBuffer: " + (endTime - startTime) + "ms");
    }

    public static void contentAnalysis(String text){
        int count = 0;
        for (int i = 0; i < text.length(); i++){
            char c = text.charAt(i);
            if (c=='.' || c == '?' || c == '!'){
                count ++;
            }
        }
        System.out.println("=> Kết quả đếm: có" + count + "câu.");
        String replacedText = text.replace("Java", "Python");
        System.out.println("=> Văn bản sau khi Replace:" + replacedText);
    }
}