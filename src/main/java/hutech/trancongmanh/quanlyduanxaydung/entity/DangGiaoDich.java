package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "DangGiaoDich")
public class DangGiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String DangGiaoDich;

    @OneToMany(mappedBy = "danggiaodich") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<QuanLyGiaoDichDuAn> quanlygiaodichduan;

    @OneToMany(mappedBy = "danggiaodich") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<QuanLyGiaoDichVatTu> quanlygiaodichvattu;
}
