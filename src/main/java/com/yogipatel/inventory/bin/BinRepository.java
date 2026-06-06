package com.yogipatel.inventory.bin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin, Long> {
    List<Bin> findByCabinetIdOrderByBinNumberAscNameAsc(Long cabinetId);   
}
