package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.TrangThai;
import hutech.trancongmanh.quanlyduanxaydung.repository.TrangThaiRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrangThaiService {

    @Autowired
    private TrangThaiRepository trangThaiRepository;

    public TrangThai createTrangThai(TrangThai trangThai) {
        // Set other fields if needed
        TrangThai savedTrangThai = trangThaiRepository.save(trangThai);
        return savedTrangThai;
    }

    public TrangThai getTrangThaiById(Long trangThaiId) {
        Optional<TrangThai> trangThaiOptional = trangThaiRepository.findById(trangThaiId);
        return trangThaiOptional.orElse(null);
    }

    public TrangThai updateTrangThai(Long trangThaiId, TrangThai trangThai) {
        Optional<TrangThai> trangThaiOptional = trangThaiRepository.findById(trangThaiId);
        if (trangThaiOptional.isPresent()) {
            TrangThai existingTrangThai = trangThaiOptional.get();
            // Copy information from DTO to existing entity
            BeanUtils.copyProperties(trangThai, existingTrangThai);
            // Update other fields if needed
            TrangThai updatedTrangThai = trangThaiRepository.save(existingTrangThai);
            return updatedTrangThai;
        }
        return null;
    }

    public boolean deleteTrangThai(Long trangThaiId) {
        if (trangThaiRepository.existsById(trangThaiId)) {
            trangThaiRepository.deleteById(trangThaiId);
            return true;
        }
        return false;
    }

    public List<TrangThai> getAllTrangThai() {
        return trangThaiRepository.findAll();
    }
}
