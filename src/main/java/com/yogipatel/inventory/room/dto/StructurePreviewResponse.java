package com.yogipatel.inventory.room.dto;
import java.util.List;

public record StructurePreviewResponse (
    List<RoomPreviewResponse> rooms
) {}
