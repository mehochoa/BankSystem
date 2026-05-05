public class  PayrollSystem {
    //B1: đặt tên cho các con số, hằng số đơn giản
    private final double phanTramBaoHiemXaHoi = 0.08;
    private final double phanTramBaoHiemYTe = 0.015;
    private final double mucGiamTruGiaCanh = 11000000;

    private final double nguongThueBac1 = 5000000;
    private final double nguongThueBac2 = 10000000;
    private final double thueSuatBac1 = 0.05;
    private final double thueCoDinhBac2 = 250000;
    private final double thueCoDinhBac3 = 750000;

    //B2: Các hàm tính toán
    //Tính lương thực tế dựa trên ngày công
    private double tinhLuongThucTe(double luongCoBan, int ngayCong, int tongNgay) {
        return luongCoBan * ngayCong / tongNgay;
    }
    //Tính tiền bảo hiểm
    private double tinhTienBaoHiem(double luongThucTe) {
        double baoHiemXaHoi = luongThucTe * phanTramBaoHiemXaHoi;
        double baoHiemYTe = luongThucTe * phanTramBaoHiemYTe;
        return baoHiemXaHoi + baoHiemYTe;
    }
    //Tính thuế thu nhập cá nhân
    private double tinhThueThuNhapCaNhan(double luongThucTe, double tienBaoHiem, double thueSuatBac3) {
        double thuNhapTinhThue = luongThucTe - tienBaoHiem - mucGiamTruGiaCanh;
        if (thuNhapTinhThue <= 0) return 0;
        if (thuNhapTinhThue <= nguongThueBac1) { return thuNhapTinhThue * thueSuatBac1; }
        else if (thuNhapTinhThue <= nguongThueBac2) { return thueCoDinhBac2 + (thuNhapTinhThue - nguongThueBac1) * 0.1; }
        else { return thueCoDinhBac3 + (thuNhapTinhThue - nguongThueBac2) * thueSuatBac3; }
    }
    //Hàm in bảng lương
    public void printPayroll(String name, double luongCoBan, int ngayCong, int tongNgay, double thueSuat, double thuong) {
        double luongThucTe = tinhLuongThucTe(luongCoBan, ngayCong, tongNgay);
        double baoHiem = tinhTienBaoHiem(luongThucTe);
        double thue = tinhThueThuNhapCaNhan(luongThucTe, baoHiem, thueSuat);
        double thucNhan = luongThucTe - baoHiem - thue + thuong;

        System.out.println("---BẢNG LƯƠNG---");
        System.out.println("Nhân viên: " + name);
        System.out.println("Lương cơ bản: " + luongCoBan);
        System.out.println("Ngày công: " + ngayCong + "/" + tongNgay);
        System.out.println("Lương thực tế: "+ luongThucTe);
        System.out.println("Bảo hiểm: " + baoHiem);
        System.out.println("Thuế thu nhập cá nhân: " + thue);
        System.out.println("Thưởng: " + thuong);
        System.out.println("Thực nhận: " + thucNhan);
        System.out.println("------------------------");
    }

    static void main(String[] args) {
        PayrollSystem run = new PayrollSystem();
        String tenNV = "NGUYEN VAN A";
        double luongChinh = 2500000;
        int soNgayLam = 22;
        int tongNgayTrongThang = 26;
        double thueBacCao = 0.15;
        double tienThuong = 200000;

        run.printPayroll(tenNV, luongChinh, soNgayLam,tongNgayTrongThang, thueBacCao, tienThuong);
    }
}