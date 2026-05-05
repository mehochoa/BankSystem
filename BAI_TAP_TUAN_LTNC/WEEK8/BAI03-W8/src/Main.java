//  Vấn đề 1: 2 biến fuelLevel và batteryPercent đang bị đặt ở lớp cha Vehicle
//trong khi đó xe máy và xe xăng ko dùng đến batteryPercent, xe điện ko dùng fuelLevel
//ko nên để ở lớp cha, tránh gây lãng phí bộ nhớ và tạo sự nhầm lẫn
//  GIẢI PHÁP: đưa các thuộc tính đặc thù xuống lớp con hoặc tạo lớp trung gian
//  Vấn đề 2: phương thức getInfo(): cấu trúc chuõi trả về ở lớp con gần như giống nhau, nếu sau này muốn thay đổi thì phải sửa hết lớp con
//  GIẢI PHÁP: sd Pull Up Method và phương thức trừu tượng để lấy tên xe

abstract class Vehicle {
    protected String plate;
    protected String brand;

    public Vehicle(String plate, String brand) {
        this.plate = plate;
        this.brand = brand;
    }

    protected abstract String getVehicleType();

    public String getInfo() {
        return getVehicleType() + " [ " + plate + " ] - " + brand;
    }
}

abstract class GasVehicle extends Vehicle {
    protected double fuelLevel;

    public GasVehicle(String plate, String brand) {
        super(plate, brand);
    }

    public void refuel(double liters) {
        this.fuelLevel += liters;
    }
}

abstract class ElectricVehicle extends Vehicle {
    protected int batteryPercent;

    public ElectricVehicle(String plate, String brand) {
        super(plate, brand);
    }

    public void charge(int percent) {
        this.batteryPercent += percent;
    }
}

class MotorBike extends GasVehicle {
    public MotorBike(String plate, String brand) {
        super(plate, brand);
    }
    @Override
    protected String getVehicleType() {
        return "Motorbike";
    }
}

class Car extends GasVehicle {
    public Car(String plate, String brand) {
        super (plate, brand);
    }
    @Override
    protected String getVehicleType() {
        return "Car";
    }
}

class ElectricCar extends ElectricVehicle {
    public ElectricCar(String plate, String brand) {
        super(plate, brand);
    }
    @Override
    protected String getVehicleType() {
        return "ElectricCar";
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle motor = new MotorBike("18-A1 123.45", "Honda");
        Vehicle gasCar = new Car("36-H2 567.89", "Toyota");
        Vehicle evCar = new ElectricCar("29-E3 999.99", "Maybach");

        System.out.println(motor.getInfo());
        System.out.println(gasCar.getInfo());
        System.out.println(evCar.getInfo());
    }
}