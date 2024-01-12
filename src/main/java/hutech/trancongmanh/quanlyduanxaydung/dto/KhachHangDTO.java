//package hutech.trancongmanh.quanlyduanxaydung.dto;
//
//import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class KhachHangDTO {
//    private Long id;
//    private String TenKhachHang;
//    private String DiaChi;
//    private String SDT;
//    private String Email;
//    private String TenNganHang;
//    private String SoTaiKhoan;
//
//    // Thêm các trường khác nếu cần
//
//    public KhachHangDTO() {
//        // Khởi tạo constructor mặc định
//    }
//
//    // Tạo một phương thức để chuyển từ Entity (KhachHang) sang DTO (KhachHangDTO)
//    public static KhachHangDTO fromEntity(KhachHang khachHang) {
//        KhachHangDTO khachHangDTO = new KhachHangDTO();
//        khachHangDTO.setId(khachHang.getId());
//        khachHangDTO.setTenKhachHang(khachHang.getTenKhachHang());
//        khachHangDTO.setDiaChi(khachHang.getDiaChi());
//        khachHangDTO.setSDT(khachHang.getSDT());
//        khachHangDTO.setEmail(khachHang.getEmail());
//        khachHangDTO.setTenNganHang(khachHang.getTenNganHang());
//        khachHangDTO.setSoTaiKhoan(khachHang.getSoTaiKhoan());
//        // Sao chép các trường khác nếu cần
//        return khachHangDTO;
//    }
//}
//
