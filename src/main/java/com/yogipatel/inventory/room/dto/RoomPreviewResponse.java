package com.yogipatel.inventory.room.dto;

import java.util.List;

public record RoomPreviewResponse (
    String name,
    List<CabinetPreviewResponse> cabinets
){}
