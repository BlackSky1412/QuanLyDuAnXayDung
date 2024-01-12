package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "ChucVu")
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenChucVu;


    @OneToMany(mappedBy="chucvu") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<NhanVien> nhanvien;
}
