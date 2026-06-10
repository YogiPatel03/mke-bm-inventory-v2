package com.yogipatel.inventory.bin.dto;

public record CreateBinRequest(
    String name,
    String shelfCode,
    Integer binNumber,
    String description
) {}
