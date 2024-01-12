package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;



import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "DuAn")
public class DuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String TenDuAn;
    private String DiaChi;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKhoiCong;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayHoanThanhDuKien;
    private Long ChiPhiUocTinh;
    @Column(nullable = true)
    private Long ChiPhiThucTe;
    private String giayPhepXayDungPath;
    private String banThietKePath;


    @ManyToOne
    @JoinColumn(name = "khachhang_id", nullable = false)
    private KhachHang khachhang;


    @ManyToOne
    @JoinColumn(name = "CachThucThanhToan_id", nullable = false)
    private CachThucThanhToan cachthucthanhtoan;


    @ManyToOne
    @JoinColumn(name = "TrangThai_id", nullable = false)
    private TrangThai trangthai;

    public void settrangthai(TrangThai trangthai) {
        this.trangthai = trangthai;
    }
    public void setkhachhang(KhachHang khachhang) {
        this.khachhang = khachhang;
    }

    public void setCachThucThanhToan(CachThucThanhToan cachthucthanhtoan) {
        this.cachthucthanhtoan = cachthucthanhtoan;
    }

    @OneToMany(mappedBy = "duan")
    Set<ChiTietDuAn> chitietduan;


    @OneToMany(mappedBy = "duan") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<QuanLyGiaoDichDuAn> quanlygiaodichduan;

    @OneToMany(mappedBy = "duan") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<ChiTietVatTu> chitietvattu;

    @OneToMany(mappedBy = "duan")
    Set<ChiTietVanDePhatSinh> chitietvandephatsinh;

    @OneToMany(mappedBy="duan") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<BangTheoDoiTienDo> bangtheodoitiendo;

}
