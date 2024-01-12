package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ChiTietDuAn")
public class ChiTietDuAn {
    @EmbeddedId
    ChiTietDuAn_Key id;

    @ManyToOne
    @MapsId("NhaThau_id")
    @JoinColumn(name = "NhaThau_id")
    NhaThau nhathau;

    @ManyToOne
    @MapsId("DuAn_id")
    @JoinColumn(name = "DuAn_id")
    DuAn duan;

}