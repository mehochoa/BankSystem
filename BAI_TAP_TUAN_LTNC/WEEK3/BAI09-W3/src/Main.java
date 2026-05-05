import java.util.*;

interface IPayable {
    double getPaymentAmount();
}

abstract class Staff implements IPayable {
    private String id, name;

    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class PartTimeStaff extends Staff {
    private int workingHour;
    private double hourlyRate;

    public PartTimeStaff(String id, String name, int work, double hour) {
        super(id, name);
        this.workingHour = work;
        this.hourlyRate = hour;
    }

    public double getPaymentAmount() {
        return workingHour * hourlyRate;
    }

    public String toString() {
        return "PartTimeStaff " + super.getName() + " - Payment: " + getPaymentAmount();
    }
}

class Invoice implements IPayable {
    private String itemName;
    private int quanlity;
    private double pricePerItem;

    public Invoice(String item, int quanlity, double price) {
        this.itemName = item;
        this.quanlity = quanlity;
        this.pricePerItem = price;
    }

    public double getPaymentAmount() {
        return quanlity * pricePerItem;
    }

    public String toString() {
        return "Invoice " + itemName + " - Payment: " + getPaymentAmount();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        IPayable[] payableList = new IPayable[n];
        for(int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            if(parts[0].equals("S")) {
                payableList[i] = new PartTimeStaff(parts[1], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
            }
            else {
                payableList[i] = new Invoice(parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[3]));
            }
        }
        double total = 0.0;
        for(int i = 0; i < n; i++) {
            System.out.println(payableList[i]);
            total += payableList[i].getPaymentAmount();
        }
        System.out.println("Total Payment = " + total);
    }
}