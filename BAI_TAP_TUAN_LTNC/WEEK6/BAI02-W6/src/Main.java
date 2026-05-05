interface Notification {
    void send(String msg);
}

class EmailNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Đang gửi EMAIL với nội dung: " + msg);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String msg) {
        System.out.println("Đang gửi SMS với nội dung: " + msg);
    }
}

abstract class NotificationApp {
    public void notifyUser(String msg) {
        Notification notification = createNotification();
        notification.send(msg);
    }
    protected abstract Notification createNotification();
}

class EmailApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new EmailNotification();
    }
}

class SmsApp extends NotificationApp {
    @Override
    protected Notification createNotification() {
        return new SmsNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationApp emailApp = new EmailApp();
        emailApp.notifyUser("Mã OTP của bạn là 123456");

        NotificationApp smsApp = new SmsApp();
        smsApp.notifyUser("Tài khoản của bạn vừa được cộng tiền");
    }
}