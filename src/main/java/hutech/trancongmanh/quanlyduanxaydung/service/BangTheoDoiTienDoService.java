package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.BangTheoDoiTienDo;
import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import hutech.trancongmanh.quanlyduanxaydung.repository.BangTheoDoiTienDoRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.DuAnRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.NhaThauRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BangTheoDoiTienDoService {

    @Autowired
    private BangTheoDoiTienDoRepository bangtheodoitiendoRepository;

    @Autowired
    private DuAnRepository duAnRepository;

    @Autowired
    private NhaThauRepository nhaThauRepository;

    public List<BangTheoDoiTienDo> getAllTienDoForDuAn(Long duAnId) {
        // Assuming you have a repository named yourBangTheoDoiTienDoRepository
        List<BangTheoDoiTienDo> allTienDo = bangtheodoitiendoRepository.findAll();

        // Filter the progress updates based on the given project ID
        List<BangTheoDoiTienDo> tienDoForDuAn = allTienDo.stream()
                .filter(tienDo -> tienDo.getDuan().getId().equals(duAnId))
                .collect(Collectors.toList());

        return tienDoForDuAn;
    }
    public List<BangTheoDoiTienDo> getAllTienDoForNhaThau(Long nhaThauId) {
        // Assuming you have a repository named yourBangTheoDoiTienDoRepository
        List<BangTheoDoiTienDo> allTienDo = bangtheodoitiendoRepository.findAll();

        // Filter the progress updates based on the given contractor ID
        List<BangTheoDoiTienDo> tienDoForNhaThau = allTienDo.stream()
                .filter(tienDo -> tienDo.getNhathau().getId().equals(nhaThauId))
                .collect(Collectors.toList());

        return tienDoForNhaThau;
    }

    public Optional<BangTheoDoiTienDo> getBangTheoDoiTienDoById(Long bangTheoDoiTienDoId) {
        return bangtheodoitiendoRepository.findById(bangTheoDoiTienDoId);
    }

    @Transactional
    public void Update(BangTheoDoiTienDo bangtheodoitiendo) {
        DuAn duAn = duAnRepository.findById(bangtheodoitiendo.getDuan().getId()).orElse(null);
        NhaThau nhaThau = nhaThauRepository.findById(bangtheodoitiendo.getNhathau().getId()).orElse(null);

        bangtheodoitiendo.setDuan(duAn);
        bangtheodoitiendo.setNhathau(nhaThau);

        bangtheodoitiendoRepository.save(bangtheodoitiendo);
    }
}
