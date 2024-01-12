package hutech.trancongmanh.quanlyduanxaydung.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "NhaThau")
public class NhaThau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenNhaThau;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String TenNganHang;
    private String SoTaiKhoan;


    @OneToMany(mappedBy = "nhathau")
    Set<ChiTietDuAn> chitietduan;

    @OneToMany(mappedBy = "nhathau") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<ChiTietVatTu> chitietvattu;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "thongtintaikhoan_id")
    private ThongTinTaiKhoan thongtintaikhoan;

    @OneToMany(mappedBy="nhathau") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<BangTheoDoiTienDo> bangtheodoitiendo;
}
