
package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class ChiTietVanDePhatSinh_Key implements Serializable {
    @Column(name = "DuAn_id")
    Long DuAnId;

    @Column(name = "VanDePhatSinh_id")
    Long VanDePhatSinhId;
}

