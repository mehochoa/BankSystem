class AppConfig {
    private static volatile AppConfig instance;

    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
        this.appName = "My Application";
        this.version = "1.0.0";
        this.logLevel = "INFO";
        System.out.println("Đã khởi tạo AppConfig mới!");
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
    public String getAppName() {
        return appName;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Kiểm tra Singleton Đa Luồng ---");

        Thread thread1 = new Thread(() -> {
            AppConfig config1 = AppConfig.getInstance();
            System.out.println("Luồng 1 - HashCode của AppConfig: " + config1.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            AppConfig config2 = AppConfig.getInstance();
            System.out.println("Luồng 2 - HashCode của AppConfig: " + config2.hashCode());
        });

        thread1.start();
        thread2.start();
    }
}