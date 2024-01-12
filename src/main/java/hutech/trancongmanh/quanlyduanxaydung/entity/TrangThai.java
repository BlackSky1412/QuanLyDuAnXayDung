package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "TrangThai")
public class TrangThai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String TenTrangThai;


    @OneToMany(mappedBy="trangthai") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<DuAn> duan;

    @OneToMany(mappedBy="trangthai") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<ChiTietTienDo> chitiettiendo;
}
