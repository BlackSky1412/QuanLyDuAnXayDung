package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "BangTheoDoiTienDo")
public class BangTheoDoiTienDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String NoiDung;
    private String YeuCauCanDat;
    @Column(nullable = true)
    private Long TenDoTienQuyetID;


    @ManyToOne
    @JoinColumn(name = "NhaThau_id", nullable = true)
    private NhaThau nhathau;

    @OneToMany(mappedBy = "bangtheodoitiendo")
    Set<ChiTietPhat> chitietphat;

    @ManyToOne
    @JoinColumn(name = "DuAn_id", nullable = false)
    private DuAn duan;

    public DuAn getDuan() {
        return duan;
    }

    public void setDuan(DuAn duan) {
        this.duan = duan;
    }


    @OneToMany(mappedBy = "bangtheodoitiendo") // Điều chỉnh "mappedBy" thành tên thuộc tính trong lớp DuAn
    private Set<ChiTietTienDo> chitiettiendo;
}
