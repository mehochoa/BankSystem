import java.io.*;
import java.util.*;

class Student implements Serializable{
    // serialVersionUID giúp kiểm soát phiên bản của class khi đọc/ghi file
    private static final long serialVersionUID = 1L;
    String id, name;
    double gpa;

    public Student(String id, String name, double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        while (true){
            System.out.print("Nhập ID (nhập 'END' để dừng): ");
            String id = sc.nextLine();
            if (id.equalsIgnoreCase("END")) break;
            System.out.print("Nhập tên: ");
            String name = sc.nextLine();
            System.out.print("Nhập GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            //Thêm sinh viên mới vào danh sách
            list.add(new Student(id, name, gpa));
        }

        String file = "students.bin";
        //ghi đối tượng xuống file
        //ObjectOutputStream: Luồng ghi đối tượng
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(list);
            System.out.println("Đã ghi danh sách vào tệp.");
        } catch (IOException e){
            e.printStackTrace();
        }

        //đọc đối tượng từ file
        //ObjectInputStream: Luồng đọc đối tượng
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            // Đọc đối tượng và ép kiểu về List<Student>
            List<Student> readList = (List<Student>) ois.readObject();
            System.out.println("--- Danh sách đọc được từ file---");
            readList.forEach(System.out::println);
        }catch (EOFException e){
            // Xảy ra khi đọc tệp rỗng hoặc kết thúc tệp đột ngột
        }catch (FileNotFoundException e){
            System.out.println("Lỗi: Không tìm thấy tệp dữ liệu.");
        }catch (IOException | ClassNotFoundException e){
            // ClassNotFoundException: Xảy ra nếu class Student bị xóa mất trong code
            e.printStackTrace();
        }
    }
}