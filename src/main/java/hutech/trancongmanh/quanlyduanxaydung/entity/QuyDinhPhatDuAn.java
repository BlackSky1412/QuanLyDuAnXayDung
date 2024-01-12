package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@Table(name = "QuyDinhPhatDuAn")
public class QuyDinhPhatDuAn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String QuyDinhPhat;
    private int SoPhanTramTru;

    @OneToMany(mappedBy = "quydinhphatduan")
    Set<ChiTietPhat> chitietphat;
}
