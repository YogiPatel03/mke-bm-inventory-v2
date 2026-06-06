package com.yogipatel.inventory.bin;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogipatel.inventory.cabinet.Cabinet;
import com.yogipatel.inventory.cabinet.CabinetRepository;

@Service
public class BinService {

    private final BinRepository binRepo;
    private final CabinetRepository cabinetRepo;

    public BinService(BinRepository binRepo, CabinetRepository cabinetRepo) {
        this.binRepo = binRepo;
        this.cabinetRepo = cabinetRepo;
    }

    public List<Bin> getBinsByCabinetId(Long cabinetId) {
        return binRepo.findByCabinetIdOrderByBinNumberAscNameAsc(cabinetId);
    }

    public Bin createBin(Long cabinetId, String name, String shelfCode, Integer binNumber, String description) {
        Cabinet cabinet = cabinetRepo.findById(cabinetId)
            .orElseThrow(() -> new IllegalArgumentException("Cabinet " + cabinetId + " not found"));

        return binRepo.save(new Bin(name, shelfCode, binNumber, description, cabinet));
    }
}
