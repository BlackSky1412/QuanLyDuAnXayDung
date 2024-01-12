package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "VanDePhatSinh")
public class VanDePhatSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenVanDe;
    private String NguyenNhan;
    @Column(name = "cachGiaiQuyet")
    private String CachGiaiQuyet;
    private String KetQua;

    @OneToMany(mappedBy = "vandephatsinh")
    Set<ChiTietVanDePhatSinh> chitietvandephatsinh;
}
