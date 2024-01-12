//package hutech.trancongmanh.quanlyduanxaydung.dto;
//
//import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
//import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
//import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.Date;
//
//@Getter
//@Setter
//public class DuAnDTO {
//    private Long id;
//    private String tenDuAn;
//    private String diaChi;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date ngayKy;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date ngayKhoiCong;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date ngayHoanThanhDuKien;
//    private Long chiPhiUocTinh;
//    private Long chiPhiThucTe;
//    private MultipartFile giayPhepXayDung;
//    private MultipartFile banThietKe;
//
//    private String giayPhepXayDungPath;
//    private String banThietKePath;
//
//    private KhachHangDTO khachhang;
//
//    private CachThucThanhToanDTO cachThucThanhToan;
//
//
//    public void setKhachHang(KhachHangDTO khachhang) {
//        this.khachhang = khachhang;
//    }
//    public void setCachThucThanhToan(CachThucThanhToanDTO cachThucThanhToan) {
//        this.cachThucThanhToan = cachThucThanhToan;
//    }
//
//    public DuAnDTO() {
//        // Khởi tạo constructor mặc định
//    }
//
//    // Tạo một phương thức để chuyển từ Entity (DuAn) sang DTO (DuAnDTO)
//    public static DuAnDTO fromEntity(DuAn duAn) {
//        DuAnDTO duAnDTO = new DuAnDTO();
//        duAnDTO.setId(duAn.getId());
//        duAnDTO.setTenDuAn(duAn.getTenDuAn());
//        duAnDTO.setDiaChi(duAn.getDiaChi());
//        duAnDTO.setNgayKy(duAn.getNgayKy());
//        duAnDTO.setNgayKhoiCong(duAn.getNgayKhoiCong());
//        duAnDTO.setNgayHoanThanhDuKien(duAn.getNgayHoanThanhDuKien());
//        duAnDTO.setChiPhiUocTinh(duAn.getChiPhiUocTinh());
//        duAnDTO.setChiPhiThucTe(duAn.getChiPhiThucTe());
//        duAnDTO.setGiayPhepXayDungPath(duAn.getGiayPhepXayDung());
//        duAnDTO.setBanThietKePath(duAn.getBanThietKe());
//        // Sao chép các trường khác nếu cần
//        return duAnDTO;
//    }
//}
//
