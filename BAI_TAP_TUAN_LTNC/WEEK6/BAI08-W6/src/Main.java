class Report {
    private String title;
    private String content;
    //constructor
    public Report(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
}
interface ReportFormatter {
    String format(Report report);
}
class JsonFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "{\n" + " \"title\":\"" + report.getTitle() + "\",\n" + "  \"content\": \"" + report.getContent() + "\"\n" + "}";
    }
}

class XmlFormatter implements ReportFormatter {
    @Override
    public String format(Report report) {
        return "<report>\n" + "  <title>" + report.getTitle() + "</title>\n" + "  <content>" + report.getContent() + "</content>\n" + "</report>";
    }
}

class ReportService {
    private ReportFormatter formatter;
    public ReportService(ReportFormatter formatter) {
        this.formatter = formatter;
    }
    public String export(Report report) {
        return formatter.format(report);
    }
}

public class Main {
    public static void main(String[] args) {
        Report report = new Report("Sale", "Sale 20%");
        ReportFormatter formatter = new JsonFormatter();
        ReportService service = new ReportService(formatter);
        String result = service.export(report);
        System.out.println(result);
    }
}