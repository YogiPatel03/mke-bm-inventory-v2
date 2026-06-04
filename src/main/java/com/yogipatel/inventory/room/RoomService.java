package com.yogipatel.inventory.room;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAllByOrderByNameAsc();
    }
    
    public Room createRoom(String name, String description) {
        Room room = new Room(name, description);
        return roomRepository.save(room);
    }
}
