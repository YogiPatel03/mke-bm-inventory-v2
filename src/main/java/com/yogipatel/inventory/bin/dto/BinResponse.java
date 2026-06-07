package com.yogipatel.inventory.bin.dto;

public record BinResponse(
    Long id,
    String name,
    String shelfCode,
    Integer binNumber,
    String description,
    Long cabinetId
) {}
