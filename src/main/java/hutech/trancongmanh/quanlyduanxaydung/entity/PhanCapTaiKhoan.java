package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "PhanCapTaiKhoan")
public class PhanCapTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenCap;


    @OneToMany(mappedBy="phancaptaikhoan") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<ThongTinTaiKhoan> thongtintaikhoan;
}
