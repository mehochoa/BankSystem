import java.util.ArrayList;
import java.util.List;

abstract class DeliveryStrategy {
    public abstract double calculateFee(double weight, double distance);
    public abstract String getLabel();
}

class StandardDelivery extends DeliveryStrategy {
    public double calculateFee(double weight, double distance) {
        return weight * 3000 + distance * 500;
    }
    public String getLabel() { return "[THƯỜNG]"; }
}

class ExpressDelivery extends DeliveryStrategy {
    public double calculateFee(double weight, double distance) {
        return (weight * 3000 + distance * 500) * 1.5;
    }
    public String getLabel() { return "[HỎA TỐC]"; }
}

class FragileDelivery extends DeliveryStrategy {
    public double calculateFee(double weight, double distance) {
        return weight * 5000 + distance * 700 + 20000;
    }
    public String getLabel() { return "[HÀNG DỄ VỠ]"; }
}

class Order {
    private double weight;
    private double distance;
    private DeliveryStrategy strategy; //Đa hình

    public Order(double weight, double distance, DeliveryStrategy strategy) {
        this.weight = weight;
        this.distance = distance;
        this.strategy = strategy;
    }

    public double getDeliveryFee() {
        return strategy.calculateFee(weight, distance);
    }

    public String getLabel() {
        return strategy.getLabel();
    }
}

class BulkyDelivery extends DeliveryStrategy {
    public double calculateFee(double weight, double distance) {
        return weight * 4000 + distance * 600 + 50000;
    }
    public String getLabel() { return "[HÀNG CỒNG KỀNH]"; }
}
public class Main {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order(2.0, 10.0, new StandardDelivery()));
        orders.add(new Order(1.5, 20.0, new ExpressDelivery()));
        orders.add(new Order(0.5, 5.0, new FragileDelivery()));
        orders.add(new Order(10.0, 50.0, new BulkyDelivery()));

        System.out.println("DANH SÁCH PHÍ GIAO HÀNG:");
        for (Order o : orders) {
            System.out.println("Loai don hang: " + o.getLabel());
            System.out.println("Phi van chuyen: " + o.getDeliveryFee() + " VND");
            System.out.println("-------------------------------------------");
        }
    }
}