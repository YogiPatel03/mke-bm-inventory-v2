package com.yogipatel.inventory.room.dto;

import java.util.List;

public record CabinetPreviewResponse(
    String name,
    List<BinPreviewResponse> bins
) {}