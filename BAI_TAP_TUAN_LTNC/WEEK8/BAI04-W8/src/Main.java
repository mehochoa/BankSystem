import java.util.ArrayList;
import java.util.List;

abstract class Vehicle {
    private final String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public abstract double calculateFee(int hours);
    public abstract int calculatePoints(int hours);
}

class Car extends Vehicle {
    public Car(String plate) { super(plate); }

    @Override
    public double calculateFee(int hours) {
        double fee = 10;
        if (hours > 2) fee += (hours - 2) * 3;
        return fee;
    }
    @Override
    public int calculatePoints(int hours) { return 1; }
}

class Bike extends Vehicle {
    public Bike(String plate) { super(plate); }

    @Override
    public double calculateFee(int hours) {
        double fee = 5;
        if (hours > 3) fee += (hours - 3) * 2;
        return fee;
    }
    @Override
    public int calculatePoints(int hours) { return 1; }
}

class Truck extends Vehicle {
    public Truck(String plate) { super(plate); }

    @Override
    public double calculateFee(int hours) {
        return 15 + (hours * 4);
    }
    @Override
    public int calculatePoints(int hours) {
        return (hours > 5) ? 2 : 1; // Xe tải gửi trên 5h được 2 điểm
    }
}

class ParkingTicket {
    private final Vehicle vehicle;
    private final int hours;

    public ParkingTicket(Vehicle vehicle, int hours) {
        this.vehicle = vehicle;
        this.hours = hours;
    }

    public Vehicle getVehicle() { return vehicle; }

    public double getFee() {
        return vehicle.calculateFee(hours);
    }

    public int getPoints() {
        return vehicle.calculatePoints(hours);
    }
}

class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        StringBuilder result = new StringBuilder("--- Parking Receipt for " + name + " ---\n");

        for (ParkingTicket ticket : tickets) {
            result.append("Plate: ").append(ticket.getVehicle().getPlate())
                    .append("\tFee: $").append(ticket.getFee())
                    .append("\n");
        }

        result.append("----------------------------\n");
        result.append("Total Fee: $").append(getTotalFee()).append("\n");
        result.append("Total Bonus Points: ").append(getTotalPoints()).append("\n");

        return result.toString();
    }

    private double getTotalFee() {
        double total = 0;
        for (ParkingTicket t : tickets) total += t.getFee();
        return total;
    }

    private int getTotalPoints() {
        int total = 0;
        for (ParkingTicket t : tickets) total += t.getPoints();
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        ParkingCustomer customer = new ParkingCustomer("Tiên36");

        customer.addTicket(new ParkingTicket(new Car("36A-123.45"), 4));   // $10 + (2*3) = $16
        customer.addTicket(new ParkingTicket(new Bike("18B-999.99"), 5));  // $5 + (2*2) = $9
        customer.addTicket(new ParkingTicket(new Truck("29C-888.88"), 6)); // $15 + (6*4) = $39 (+2pts)

        System.out.println(customer.receipt());
    }
}