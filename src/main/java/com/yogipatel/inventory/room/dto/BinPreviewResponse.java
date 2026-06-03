package com.yogipatel.inventory.room.dto;

import java.util.List;

public record BinPreviewResponse (
    String name,
    List<ItemPreviewResponse> items
) {}
