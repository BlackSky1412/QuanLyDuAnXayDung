package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietDuAn_Key implements Serializable {
    @Column(name = "DuAn_id")
    Long DuAnId;

    public void setDuAnId(Long duAnId) {
        DuAnId = duAnId;
    }

    public void setNhaThauId(Long nhaThauId) {
        NhaThauId = nhaThauId;
    }

    @Column(name = "NhaThau_id")
    Long NhaThauId;
}

