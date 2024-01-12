//package hutech.trancongmanh.quanlyduanxaydung.dto;
//
//import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class CachThucThanhToanDTO {
//    private Long id;
//    private String tenCachThuc;
//    private Long soTienToiThieu;
//
//    public CachThucThanhToanDTO() {
//        // Default constructor
//    }
//
//    // Create a method to convert from Entity (CachThucThanhToan) to DTO (CachThucThanhToanDTO)
//    public static CachThucThanhToanDTO fromEntity(CachThucThanhToan cachThucThanhToan) {
//        CachThucThanhToanDTO cachThucThanhToanDTO = new CachThucThanhToanDTO();
//        cachThucThanhToanDTO.setId(cachThucThanhToan.getId());
//        cachThucThanhToanDTO.setTenCachThuc(cachThucThanhToan.getTenCachThuc());
//        cachThucThanhToanDTO.setSoTienToiThieu(cachThucThanhToan.getSoTienToiThieu());
//        // Copy other fields if needed
//        return cachThucThanhToanDTO;
//    }
//}
