import java.time.LocalDate;
import java.util.*;
import java.time.temporal.ChronoUnit;

class Product{
    String code;
    String name;
    double originalPrice;
    public Product(String code, String name, double originalPrice){
        this.code = code;
        this.name = name;
        this.originalPrice = originalPrice;
    }
    public double getFinalPrice(){
        return originalPrice;
    }
    public String getType(){
        return "Product";
    }
    public String toString(){
        return name + " - " + getType() + " - " + getFinalPrice();
    }
}
class Electronics extends Product{
    double warranty;
    public Electronics(String code, String name, double originalPrice, double warranty){
        super(code, name, originalPrice);
        this.warranty = warranty;
    }
    public double getFinalPrice(){
        return originalPrice * 1.1 + warranty;
    }
    public String getType(){
        return "Electronics";
    }
}
class Food extends Product{
    LocalDate expiryDate;
    public Food(String code, String name, double originalPrice, LocalDate expiryDate){
        super(code, name, originalPrice);
        this.expiryDate = expiryDate;
    }
    public double getFinalPrice(){
        LocalDate today = LocalDate.now();
        long daysToExpire = ChronoUnit.DAYS.between(today, expiryDate);
        if (daysToExpire < 7){
            return originalPrice*0.8;
        }
        return originalPrice;
    }
    public String getType(){
        return "Food";
    }
}
class Order{
    List<Product> products = new ArrayList<>();
    public void addProduct(Product p){
        products.add(p);
    }
    public double getTotal() {
        double sum = 0;
        for (Product p : products) {
            sum += p.getFinalPrice();
        }
        return sum;
    }
    public void printOrder(){
        for (Product p: products){
            System.out.println(p);
        }
        System.out.println("Total = " + getTotal());
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        int n = sc.nextInt();//số sản phẩm
        sc.nextLine(); //bỏ dòng thừa
        for (int i = 0; i<n; i++){
            String line = sc.nextLine();
            String[]  parts = line.split("\"");
            String type = parts[0].trim();
            String name = parts[1];
            String[] data = parts[2].trim().split(" ");
            double price = Double.parseDouble(data[0]);

            if (type.equals("E")){
                double warranty = Double.parseDouble(data[1]);
                Product p = new Electronics(String.valueOf(i) ,name, price, warranty);
                order.addProduct(p);
            }else if (type.equals("F")){
                String dateStr = data[1];
                LocalDate expiry = LocalDate.parse(dateStr);
                Product p = new Food(String.valueOf(i) ,name, price, expiry);
                order.addProduct(p);
            }
        }
        order.printOrder();
        sc.close();
    }
}