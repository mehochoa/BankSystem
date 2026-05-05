import java.util.*;

interface WifiConnectable {
    void setupWifi();
}
abstract class Device{
    protected String id;
    protected String name;
    protected boolean isOn = true;

    public Device(String id, String name){
        this.id = id;
        this.name = name;
    }
    public void turnOff(){
        this.isOn = false;
        System.out.println(name + "turn off");
    }
}
class SmartLight extends Device{
    public SmartLight(String id, String name){
        super(id, name);
    }
}
class AirConditioner extends Device implements WifiConnectable{
    public AirConditioner(String id, String name){
        super(id, name);
    }
    @Override
    public void setupWifi(){
        System.out.println(name + "connected to wifi");
    }
}
class SmartSpeaker extends Device implements WifiConnectable{
    public SmartSpeaker(String id, String name){
        super(id, name);
    }
    @Override
    public void setupWifi(){
        System.out.println(name + "connected to wifi");
    }
}
class WindowCurtain extends Device{
    public WindowCurtain(String id, String name){
        super(id, name);
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Device> devices = new ArrayList<>();
        System.out.print("Nhập số lượng thiết bị: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i=0; i<n; i++){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            if (parts.length < 3) continue;
            String type = parts[0];
            String id = parts[1];
            String name = parts[2];
            switch (type.toUpperCase()){
                case "L":
                    devices.add(new SmartLight (id, name));
                    break;
                case "AC":
                    devices.add(new AirConditioner(id, name));
                    break;
                case "S":
                    devices.add(new SmartSpeaker(id, name));
                    break;
            }
        }
        System.out.println("\nTurn Off All Devices:");
        for (Device d: devices){
            d.turnOff();
        }
        System.out.println("\nSetup Wifi:");
        for (Device d: devices){
            if (d instanceof WifiConnectable){
                ((WifiConnectable) d).setupWifi();
            }
        }
        sc.close();
    }
}