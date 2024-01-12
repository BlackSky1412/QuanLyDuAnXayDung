package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "NhaCungCapVatTu")
public class NhaCungCapVatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenNhaCungCap;
    private String VatTuCungCap;
    private String DiaChi;
    private String SDT;
    private String Email;
    private String TenNganHang;
    private String SoTaiKhoan;


    @OneToMany(mappedBy = "nhacungcapvattu") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<QuanLyGiaoDichVatTu> quanlygiaodichvattu;

    @OneToOne(mappedBy = "nhacungcapvattu", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "vattu_id")
    private VatTu vattu;
}
