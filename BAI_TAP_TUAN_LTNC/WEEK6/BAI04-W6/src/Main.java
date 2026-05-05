import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Sorter {
    int[] sort(int[] arr);
}

class LegacySorter {
    public int[] quickSort(int[] arr) {
        System.out.println("Sử dụng thuật toán QuickSort từ thư viện cũ...");
        Arrays.sort(arr);
        return arr;
    }
}

class SorterAdapter implements Sorter {
    private LegacySorter legacySorter;

    public SorterAdapter() {
        this.legacySorter = new LegacySorter();
    }

    @Override
    public int[] sort(int[] arr) {
        return legacySorter.quickSort(arr);
    }
}

class ReportTemplate implements Cloneable {
    private String title;
    private String footer;
    private List<String> sections;

    public ReportTemplate(String title, String footer) {
        this.title = title;
        this.footer = footer;
        this.sections = new ArrayList<>();
    }

    public void addSection(String section) {
        this.sections.add(section);
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getSections() {
        return sections;
    }

    @Override
    protected ReportTemplate clone() {
        try {
            ReportTemplate cloned = (ReportTemplate) super.clone();
            cloned.sections = new ArrayList<>(this.sections);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Không hỗ trợ clone", e);
        }
    }

    public void printReport() {
        System.out.println("Tiêu đề: " + title);
        System.out.println("Nội dung: " + sections);
        System.out.println("Chân trang: " + footer);
        System.out.println("-----------------");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== TEST ADAPTER ===");
        Sorter sorter = new SorterAdapter();
        int[] result = sorter.sort(new int[]{5, 2, 8, 1});
        System.out.println("Kết quả sắp xếp: " + Arrays.toString(result));

        System.out.println("\n=== TEST PROTOTYPE ===");
        ReportTemplate template = new ReportTemplate("Báo Cáo Gốc", "Bảo mật - Nội bộ");
        template.addSection("Mục 1 chung");

        ReportTemplate report1 = template.clone();
        report1.setTitle("Báo Cáo Tài Chính");
        report1.addSection("Số liệu tiền tệ");

        ReportTemplate report2 = template.clone();
        report2.setTitle("Báo Cáo Nhân Sự");
        report2.addSection("Danh sách nhân sự");

        System.out.println("BẢN GỐC:"); template.printReport();
        System.out.println("BẢN SAO 1:"); report1.printReport();
        System.out.println("BẢN SAO 2:"); report2.printReport();
    }
}