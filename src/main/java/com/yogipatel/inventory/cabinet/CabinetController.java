package com.yogipatel.inventory.cabinet;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogipatel.inventory.cabinet.dto.CabinetResponse;

@RestController
@RequestMapping("/api/rooms/{roomId}/cabinets")
public class CabinetController {
    private final CabinetService cabinetService;

    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @GetMapping
    public List<CabinetResponse> getCabinetsByRoomId(@PathVariable Long roomId) {
        return cabinetService.getCabinetsByRoomId(roomId)
            .stream()
            .map(cabinet -> new CabinetResponse(
                cabinet.getId(),
                cabinet.getName(),
                cabinet.getLocation(),
                cabinet.getDescription(),
                cabinet.getRoom().getId()
            ))
            .toList();
    }
}
