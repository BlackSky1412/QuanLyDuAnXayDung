package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "VatTu")
public class VatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenVatTu;
    private String DonViTinh;
    private Long GiaNhap;
    private Long GiaBan;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vattu_id")
    private NhaCungCapVatTu nhacungcapvattu;


    @OneToMany(mappedBy = "vattu")
    Set<ChiTietXuatVatTu> chitietxuatvattu;



}
