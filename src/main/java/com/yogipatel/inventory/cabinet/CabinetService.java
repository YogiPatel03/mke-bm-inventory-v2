package com.yogipatel.inventory.cabinet;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yogipatel.inventory.room.Room;
import com.yogipatel.inventory.room.RoomRepository;

@Service
public class CabinetService {
    private final CabinetRepository cabinetRepository;
    private final RoomRepository roomRepository;

    public CabinetService(CabinetRepository cabinetRepository, RoomRepository roomRepository) {
        this.cabinetRepository = cabinetRepository;
        this.roomRepository = roomRepository;
    }

    public List<Cabinet> getCabinetsByRoomId(Long roomId) {
        return cabinetRepository.findByRoomIdOrderByNameAsc(roomId);
    }

    public Cabinet createCabinet(Long roomId, String name, String location, String description) {
        Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new IllegalArgumentException("Room " + roomId + " not found"));
        Cabinet cabinet = new Cabinet(name, location, description, room);
        return cabinetRepository.save(cabinet);
    }
}
