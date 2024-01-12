package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.VanDePhatSinh;
import hutech.trancongmanh.quanlyduanxaydung.repository.VanDePhatSinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VanDePhatSinhService {

    @Autowired
    private VanDePhatSinhRepository vanDePhatSinhRepository;

    public List<VanDePhatSinh> getAllVanDePhatSinh() {
        return vanDePhatSinhRepository.findAll();
    }

    public VanDePhatSinh getVanDePhatSinhById(Long id) {
        Optional<VanDePhatSinh> vanDePhatSinhOptional = vanDePhatSinhRepository.findById(id);
        return vanDePhatSinhOptional.orElse(null);
    }

    public VanDePhatSinh saveVanDePhatSinh(VanDePhatSinh vanDePhatSinh) {
        return vanDePhatSinhRepository.save(vanDePhatSinh);
    }

    // Assuming you have a repository for VanDePhatSinh

    public VanDePhatSinhService(VanDePhatSinhRepository vanDePhatSinhRepository) {
        this.vanDePhatSinhRepository = vanDePhatSinhRepository;
    }

//    public List<VanDePhatSinh> getVanDeCanGiaiQuyetList() {
//        return vanDePhatSinhRepository.findByCachGiaiQuyetIsNull();
//    }
}
