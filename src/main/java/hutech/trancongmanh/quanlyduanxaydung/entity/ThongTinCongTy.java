
package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "ThongTinCongTy")
public class ThongTinCongTy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TenDuAn;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String MatKhauEmail;
    private String TenNganHang;
    private String SoTaiKhoan;

}
