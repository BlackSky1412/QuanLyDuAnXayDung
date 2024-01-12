package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenNhanVien;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgaySinh;
    private Boolean GioiTinh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayVaoLam;
    private String DiaChi;
    private String SDT;
    private String Email;

    @ManyToOne
    @JoinColumn(name = "ChuVu_id", nullable = false)
    private ChucVu chucvu;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nhanvien_id")
    private ThongTinTaiKhoan thongtintaikhoan;
}
