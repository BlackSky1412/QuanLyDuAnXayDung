package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "ChiTietTienDo")
public class ChiTietTienDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NameTask;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayBatDau;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayHoanThanh;
    private String NhanXet;

    @ManyToOne
    @JoinColumn(name = "BangTheoiDoiTienDo_id", nullable = false)
    private BangTheoDoiTienDo bangtheodoitiendo;


    @OneToMany(mappedBy="chitiettiendo") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<Anh> anh;

    @ManyToOne
    @JoinColumn(name = "TrangThai_id", nullable = false)
    private TrangThai trangthai;
}



