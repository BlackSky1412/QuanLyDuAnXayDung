package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "BacKhachHang")
public class BacKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenBac;
    private long SoTienToiThieu;
    private String ChinhSachUuDai;

    @OneToMany(mappedBy = "backhachhang", cascade = CascadeType.ALL)
    private Set<KhachHang> khachhang;

}
