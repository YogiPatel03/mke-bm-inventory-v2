package com.yogipatel.inventory.cabinet;

import com.yogipatel.inventory.room.Room;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cabinets")
public class Cabinet {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    protected Cabinet() {}

    public Cabinet(String name, String location, String description, Room room) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
