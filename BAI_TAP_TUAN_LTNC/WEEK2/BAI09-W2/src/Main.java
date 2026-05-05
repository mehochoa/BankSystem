import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private int quantity;
    private double discount;

    private static double taxRate = 0.1;
    private static double totalRevenue = 0;

    public Product(String name, double price, int quantity, double discount) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    public static void updateTaxRate(double r) {
        taxRate = r;
    }

    public double calculateFinalPrice() {
        return (price - discount) * (1 + taxRate);
    }

    public void updateDiscount(double d) {
        discount = d;
    }

    public void sell(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            totalRevenue += amount * calculateFinalPrice();
            System.out.println("Bán thành công");
        } else {
            System.err.println("Không đủ hàng trong kho");
        }
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product p1 = new Product(sc.nextLine(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
        sc.nextLine();
        Product p2 = new Product(sc.nextLine(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());

        int buy1 = sc.nextInt();
        int buy2 = sc.nextInt();

        p1.sell(buy1);
        p2.sell(buy2);

        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        Product.updateTaxRate(0.08);

        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        p1.updateDiscount(10);

        System.out.println(p1.calculateFinalPrice());
        System.out.println(p2.calculateFinalPrice());

        System.out.println(Product.getTotalRevenue());
    }
}