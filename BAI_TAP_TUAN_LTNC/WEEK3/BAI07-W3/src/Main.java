import java.util.Scanner;

abstract class Room {
    protected int nights;

    public Room(int nights) {
        this.nights = nights;
    }

    public abstract long cal();
}

class Standard extends Room {
    private final long price = 500000;

    public Standard(int night) {
        super(night);
    }

    public long cal() {
        if(nights > 3) {
            return (long)(nights * price * 0.95);
        }
        else {
            return nights * price;
        }
    }
}

class Vip extends Room {
    private final long price = 2000000;

    public Vip(int night) {
        super(night);
    }

    public long cal() {
        return nights * price;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String room = sc.next();
        int night = sc.nextInt();
        Room a;
        if(room.equals("S")) {
            a = new Standard(night);
        }
        else {
            a = new Vip(night);
        }
        System.out.println(a.cal());
    }
}