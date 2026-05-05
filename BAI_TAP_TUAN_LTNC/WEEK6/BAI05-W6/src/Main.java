class Logger {
    private static Logger instance = new Logger();
    private Logger() {}
    public static Logger getInstance() { return instance; }
    public void log(String msg) { System.out.println("[LOG]: " + msg); }
}

interface Export { void exportFile(); }
class PdfExport implements Export { public void exportFile() { System.out.println("Xuất file PDF..."); } }
class ExcelExport implements Export { public void exportFile() { System.out.println("Xuất file Excel..."); } }

class ExportFactory {
    public static Export getExport(String type) {
        if (type.equalsIgnoreCase("PDF")) return new PdfExport();
        if (type.equalsIgnoreCase("EXCEL")) return new ExcelExport();
        return null;
    }
}

class OldPlayer {
    void playFile(String name) { System.out.println("OldPlayer đang phát: " + name); }
}

interface Player {
    void play(String name);
}

class PlayerAdapter implements Player {
    private OldPlayer oldPlayer = new OldPlayer();
    @Override
    public void play(String name) {
        oldPlayer.playFile(name);
    }
}

class ConfigData implements Cloneable {
    public String setting;
    public ConfigData(String setting) { this.setting = setting; }

    @Override
    public ConfigData clone() {
        try {
            return (ConfigData) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Logger.getInstance().log("Kiểm tra yêu cầu 1 (Singleton)");

        Export doc = ExportFactory.getExport("PDF");
        doc.exportFile();

        Player player = new PlayerAdapter();
        player.play("bai_hat_mua_xuan.mp3");

        ConfigData originalConfig = new ConfigData("Dark Mode");
        ConfigData clonedConfig = originalConfig.clone();
        clonedConfig.setting = "Light Mode";

        System.out.println("Cấu hình gốc: " + originalConfig.setting);
        System.out.println("Cấu hình clone: " + clonedConfig.setting);
    }
}