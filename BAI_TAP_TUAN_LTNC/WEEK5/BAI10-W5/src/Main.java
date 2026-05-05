import java.io.*;
import java.util.*;

// 1. Tự định nghĩa một loại lỗi mới bằng cách kế thừa lớp Exception
class InvalidConfigException extends Exception{
    public InvalidConfigException(String message){
        super(message);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập đường dẫn file config: ");
        String path = sc.nextLine();
        Map<String, String> configs = new HashMap<>();
        //try-with-resources: Tự động đóng file sau khi chạy xong
        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                //Tách dòng bằng dấu "="
                String[] parts = line.split("=");
                if (parts.length == 2){
                    //.trim() để xóa khoảng trắng thừa ở hai đầu
                    configs.put(parts[0].trim(), parts[1].trim());
                }
            }

            // --- KIỂM TRA DỮ LIỆU (VALIDATION) ---
            // Lỗi 1: Thiếu các tham số bắt buộc
            if (!configs.containsKey("username") || !configs.containsKey("timeout")) {
                throw new InvalidConfigException("Lỗi: Bắt buộc phải có 'username' và 'timeout' trong file.");
            }
            // Lỗi 2: Định dạng số không hợp lệ
            int timeout = Integer.parseInt(configs.get("timeout"));
            // Lỗi 3: Giá trị không nằm trong khoảng cho phép
            if (timeout <= 0) {
                throw new InvalidConfigException("Lỗi: Tham số 'timeout' phải lớn hơn 0.");
            }
            if (configs.containsKey("maxConnections")) {
                if (Integer.parseInt(configs.get("maxConnections")) < 1)
                    throw new InvalidConfigException("Lỗi: 'maxConnections' phải ít nhất bằng 1.");
            }
            // Nếu không có lỗi nào phía trên bị ném ra (throw)
            System.out.println("Config loaded successfully: " + configs);

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found: Không tìm thấy file tại đường dẫn đã nhập.");
        } catch (NumberFormatException e) {
            // Xảy ra khi dùng Integer.parseInt() cho một chuỗi không phải là số
            System.out.println("Invalid number format: Sai định dạng số ở timeout hoặc maxConnections.");
        } catch (InvalidConfigException e) {
            // Bắt lỗi tự chế của mình và in thông báo đã thiết lập ở trên
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: Lỗi nhập xuất hệ thống.");
            e.printStackTrace();
        } finally {
            System.out.println("Program finished.");
        }
    }
}