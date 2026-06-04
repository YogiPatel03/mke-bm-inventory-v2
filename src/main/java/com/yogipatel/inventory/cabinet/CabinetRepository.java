package com.yogipatel.inventory.cabinet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
    List<Cabinet> findByRoomIdOrderByNameAsc(Long roomId);
}
