interface Notifier {
    void send(String msg);
}

class EmailNotifier implements Notifier {
    @Override
    public void send(String msg) {
        System.out.println("Send email: " + msg);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    //constructor
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    @Override
    public void send(String msg) {
        notifier.send(msg);
    }
}
class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Send SMS: " + msg);
    }
}

class FacebookNotifier extends NotifierDecorator {
    public FacebookNotifier(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Send Facebook: " + msg);
    }
}
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        notifier = new FacebookNotifier(notifier);
        notifier = new SMSNotifier(notifier);
        notifier.send("Hello Dung!");
    }
}