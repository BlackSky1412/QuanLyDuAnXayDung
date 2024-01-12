package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Table(name = "QuanLyThongTinCongTy")
public class QuanLyThongTinCongTy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenCongTy;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String MatKhauEmail;
    private String TenNganHang;
    private String SoTaiKhoan;
}
