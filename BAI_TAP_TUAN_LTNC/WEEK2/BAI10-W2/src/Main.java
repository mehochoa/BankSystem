class SmartLight {
    private String id;
    private String name;
    private int brightness;

    // Constructor đầy đủ
    public SmartLight(String id, String name, int brightness) {
        this.id = id;
        this.name = name;
        this.brightness = brightness;
    }

    // Constructor 2 tham số
    public SmartLight(String id, String name) {
        this(id, name, 50);
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    // Overload method
    public void setBrightness(String preset) {
        if (preset.equals("MAX")) {
            this.setBrightness(100);
        } else if (preset.equals("MIN")) {
            this.setBrightness(10);
        } else if (preset.equals("ECO")) {
            this.setBrightness(30);
        }
    }

    public void connectToHub(CentralHub hub) {
        hub.registerDevice(this);
    }
    public int getBrightness() {
        return brightness;
    }
    public String getName() {
        return name;
    }
}

class CentralHub {
    public void registerDevice(SmartLight light) {
        System.out.println("[HUB] Dang ket noi voi thiet bi: " + light.getName());
    }
}

public class Main {
    public static void main(String[] args) {

        CentralHub hub = new CentralHub();

        SmartLight l1 = new SmartLight("L01", "Den phong khach", 80);
        SmartLight l2 = new SmartLight("L02", "Den ngu");

        l2.setBrightness("ECO");

        l1.connectToHub(hub);
        l2.connectToHub(hub);

        System.out.println("Do sang l1: " + l1.getBrightness());
        System.out.println("Do sang l2: " + l2.getBrightness());
    }
}