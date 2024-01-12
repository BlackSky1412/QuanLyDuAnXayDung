package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "ChiTietVanDePhatSinh")
public class ChiTietVanDePhatSinh {
    @EmbeddedId
    ChiTietVanDePhatSinh_Key id;

    @ManyToOne
    @MapsId("VanDePhatSinh_id")
    @JoinColumn(name = "VanDePhatSinh_id")
    private VanDePhatSinh vandephatsinh;

    @ManyToOne
    @MapsId("DuAn_id")
    @JoinColumn(name = "DuAn_id")
    private DuAn duan;




    private Date NgayPhatSinh;
}