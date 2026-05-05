import java.util.*;
import java.util.Scanner;

abstract class Product{
    protected String id;
    protected String name;
    public Product(String id, String name){
        this.id = id;
        this.name = name;
    }
    public abstract String getInfo();
}
class Food extends Product{
    private String expiryDate;
    public Food(String id, String name, String expiryDate){
        super(id, name);
        this.expiryDate =expiryDate;
    }
    @Override
    public String getInfo(){
        return name + " - " + expiryDate;
    }
}
class Electronics extends Product{
    private int warrantyMonths;
    public Electronics(String id, String name, int warrantyMonths){
        super(id, name);
        this.warrantyMonths = warrantyMonths;
    }
    @Override
    public String getInfo(){
        return name + " - " + warrantyMonths + " tháng bảo hành";
    }
}
class WareHouse<T extends Product>{
    private List<T> list = new ArrayList<>();
    public void add(T item){
        list.add(item);
    }
    public void inventory(String label){
        System.out.println(label + ":");
        for (T item: list){
            System.out.println(item.getInfo());
        }
        System.out.println();
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        WareHouse<Food> foodStorage = new WareHouse<>();
        WareHouse<Electronics> elecStorage = new WareHouse<>();
        System.out.println("Nhập số mặt hàng: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i<n; i++){
            String line = sc.nextLine();
            String[] p = line.split(" ");
            String type = p[0];
            String id = p[1];
            String name = p[2];
            if (type.equalsIgnoreCase("F")){
                foodStorage.add(new Food(id, name, p[3]));;
            } else if (type.equalsIgnoreCase("E")){
                elecStorage.add(new Electronics(id, name, Integer.parseInt(p[3])));
            }
        }
        foodStorage.inventory("Kho Thực Phẩm");
        elecStorage.inventory("Kho Điện Tử");
        sc.close();
    }
}