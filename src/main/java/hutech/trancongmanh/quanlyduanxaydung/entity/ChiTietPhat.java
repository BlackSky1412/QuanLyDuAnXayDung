package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ChiTietPhat")
public class ChiTietPhat {
    @EmbeddedId
    ChiTietPhat_Key id;

    @ManyToOne
    @MapsId("QuyDinhPhatDuAn_id")
    @JoinColumn(name = "QuyDinhPhatDuAn_id")
    QuyDinhPhatDuAn quydinhphatduan;

    @ManyToOne
    @MapsId("BangTheoDoiTienDo_id")
    @JoinColumn(name = "BangTheoDoiTienDo_id")
    BangTheoDoiTienDo bangtheodoitiendo;

}