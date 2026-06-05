package com.yogipatel.inventory.cabinet.dto;

public record CreateCabinetRequest(
    String name,
    String description,
    String location
) {}
