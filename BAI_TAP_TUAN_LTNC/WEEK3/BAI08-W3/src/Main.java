import java.util.ArrayList;
import java.util.Scanner;

class AmphibiousRobot extends Robot implements Flyable, Swimmable, GPS {
    public AmphibiousRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getModelName() + " performing main task");
        this.fly();
        this.swim();
        this.getCoordinates();
    }

    @Override
    public void fly() {
        System.out.println(this.getModelName() + " flying");
    }

    @Override
    public void swim() {
        System.out.println(this.getModelName() + " swimming");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getModelName() + " getting coordinates");
    }
}
class DroneRobot extends Robot implements Flyable, GPS, ElectronicDevice {
    public DroneRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getModelName() + " performing main task");
        this.fly();
        this.getCoordinates();
    }

    @Override
    public void fly() {
        System.out.println(this.getModelName() + " flying");
    }

    @Override
    public void getCoordinates() {
        System.out.println(this.getModelName() + " getting coordinates");
    }

    @Override
    public void turnOn() {}
}
interface ElectronicDevice {
    void turnOn();
}
class FishRobot extends Robot implements Swimmable {
    public FishRobot(int id, String modelName) {
        super(id, modelName);
    }

    @Override
    public void performMainTask() {
        System.out.println(this.getModelName() + " performing main task");
        this.swim();
    }

    @Override
    public void swim() {
        System.out.println(this.getModelName() + " swimming");
    }
}
interface Flyable {
    public void fly();
}
interface GPS {
    public void getCoordinates();
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        ArrayList<Robot> robots = new ArrayList<Robot>();

        for (int i = 0; i < n; i ++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            String type = parts[0];
            int id = Integer.parseInt(parts[1]);
            String modelName = parts[2];

            if (type.equals("DR")) {
                robots.add(new DroneRobot(id, modelName));
            } else if (type.equals("FR")) {
                robots.add(new FishRobot(id, modelName));
            } else if (type.equals("AR")) {
                robots.add(new AmphibiousRobot(id, modelName));
            }
        }

        System.out.println("---------------");

        for (Robot robot : robots) {
            robot.performMainTask();
            System.out.println();
        }

        Robot robot = robots.remove(0);
        // robot.fly(); // Không thể gọi do lớp Robot không cài đặt interface Flyable

        if (robot instanceof Flyable) {
            DroneRobot droneRobot = (DroneRobot) robot;
            droneRobot.fly(); // Đã gọi được hàm fly()
        } else {
            System.out.println("Robot này không có kỹ năng bay!");
        }

        robot = robots.remove(0);
        if (robot instanceof Swimmable) {
            FishRobot fishRobot = (FishRobot) robot;
            fishRobot.swim();
        } else {
            System.out.println("Robot này không có kỹ năng bơi!");
        }

        robot = robots.remove(0);
        if (robot instanceof GPS) {
            AmphibiousRobot amphibiousRobot = (AmphibiousRobot) robot;
            amphibiousRobot.getCoordinates();
        } else {
            System.out.println("Robot này không có kỹ năng lấy tọa độ!");
        }

        scanner.close();
    }
}
abstract class Robot {
    private int id;
    private String modelName;
    private int batteryLevel;

    public Robot(int id, String modelName) {
        this.id = id;
        this.modelName = modelName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void chargeBattery() {
        this.batteryLevel = 100;
    }

    public final void showIdentity() {
        System.out.printf("ID: %d - Model: %s\n", this.id, this.modelName);
    }

    public abstract void performMainTask();
}

