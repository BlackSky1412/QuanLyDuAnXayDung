package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Setter
@Getter
@Table(name = "QuanLyGiaoDichVatTu")
public class QuanLyGiaoDichVatTu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenGiaoDich;
    private Date NgayGiaoDich;
    private String NoiDung;

    @ManyToOne
    @JoinColumn(name="danggiaodich_id", nullable=false)
    private DangGiaoDich danggiaodich;

    @ManyToOne
    @JoinColumn(name="NhaCungCapVatTu_id", nullable=false)
    private NhaCungCapVatTu nhacungcapvattu;
}
