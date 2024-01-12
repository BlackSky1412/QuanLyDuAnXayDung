package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "CachThucThanhToan")
public class CachThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenCachThuc;
    private Long SoTienToiThieu;

    @OneToMany(mappedBy="cachthucthanhtoan") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<DuAn> duan;


}

