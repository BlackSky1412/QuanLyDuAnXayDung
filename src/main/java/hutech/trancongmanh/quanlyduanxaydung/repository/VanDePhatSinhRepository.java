package hutech.trancongmanh.quanlyduanxaydung.repository;


import hutech.trancongmanh.quanlyduanxaydung.entity.VanDePhatSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VanDePhatSinhRepository extends JpaRepository<VanDePhatSinh, Long> {

//    List<VanDePhatSinh> findByCachGiaiQuyetIsNull();
}
