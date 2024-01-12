
package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietXuatVatTu_Key implements Serializable {
    @Column(name = "VatTu_id")
    Long VatTuId;

    @Column(name = "ChiTietVatTu_id")
    Long ChiTietVatTuId;
}

