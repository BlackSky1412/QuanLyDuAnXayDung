package hutech.trancongmanh.quanlyduanxaydung.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Setter
@Getter
@Table(name = "Anh")
public class Anh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Path;

    @ManyToOne
    @JoinColumn(name = "ChiTietTienDo_id", nullable = false)
    private ChiTietTienDo chitiettiendo;



}
