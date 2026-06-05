package com.yogipatel.inventory.cabinet.dto;

public record CabinetResponse(
    Long id,
    String name,
    String location,
    String description,
    Long roomId
) {}
