package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Entity
@Setter
@Getter
@Table(name = "QuanLyGiaoDichDuAn")
public class QuanLyGiaoDichDuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String TenGiaoDich;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayGiaoDich;
    private String NoiDung;

    @ManyToOne
    @JoinColumn(name="duan_id", nullable=false)
    private DuAn duan;

    @ManyToOne
    @JoinColumn(name="danggiaodich_id", nullable=false)
    private DangGiaoDich danggiaodich;
}
