package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "ChiTietVatTu")
public class ChiTietVatTu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenNguoiLay;


    @OneToMany(mappedBy = "chitietvattu")
    Set<ChiTietXuatVatTu> chitietxuatvattu;

    @ManyToOne
    @JoinColumn(name="duan_id", nullable=false)
    private DuAn duan;

    @ManyToOne
    @JoinColumn(name="nhathau_id", nullable=false)
    private NhaThau nhathau;
}
