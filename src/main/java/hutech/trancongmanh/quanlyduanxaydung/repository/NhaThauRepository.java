package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaThauRepository extends JpaRepository<NhaThau, Long> {

}