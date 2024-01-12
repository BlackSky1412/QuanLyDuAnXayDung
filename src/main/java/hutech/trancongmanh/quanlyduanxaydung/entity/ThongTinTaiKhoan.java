package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ThongTinTaiKhoan")
public class ThongTinTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String HoTenNguoiDung;
    private String TenDangNhap;
    private String MatKhau;
    private String Email;

    @OneToOne(mappedBy = "thongtintaikhoan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "nhathau_id")
    private NhaThau nhathau;

    @OneToOne(mappedBy = "thongtintaikhoan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "khachhang_id")
    private KhachHang khachhang;

    @OneToOne(mappedBy = "thongtintaikhoan", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "nhanvien_id")
    private NhanVien nhanvien;

    @ManyToOne
    @JoinColumn(name="PhanCapTaiKhoan_id", nullable=false)
    private PhanCapTaiKhoan phancaptaikhoan;
    }
