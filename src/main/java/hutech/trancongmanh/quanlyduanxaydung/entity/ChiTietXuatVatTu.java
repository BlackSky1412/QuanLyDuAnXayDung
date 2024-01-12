package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "ChiTietXuatVatTu")
public class ChiTietXuatVatTu {

    @EmbeddedId
    ChiTietXuatVatTu_Key id;

    private Date NgayXuatKho;
    private int SoLuong;

    @ManyToOne
    @MapsId("VatTu_id")
    @JoinColumn(name = "VatTu_id")
    VatTu vattu;

    @ManyToOne
    @MapsId("ChiTietVatTu_id")
    @JoinColumn(name = "ChiTietVatTu_id")
    ChiTietVatTu chitietvattu;

}