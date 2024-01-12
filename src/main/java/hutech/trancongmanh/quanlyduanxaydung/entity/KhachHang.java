package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenKhachHang;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String TenNganHang;
    private String SoTaiKhoan;

    @OneToMany(mappedBy = "khachhang") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<DuAn> duan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ThongTinTaiKhoan_id")
    private ThongTinTaiKhoan thongtintaikhoan;

    @ManyToOne
    @JoinColumn(name="BacKhachHang_id", nullable=false)
    private BacKhachHang backhachhang;
}
