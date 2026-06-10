package com.yogipatel.inventory.bin;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogipatel.inventory.bin.dto.BinResponse;
import com.yogipatel.inventory.bin.dto.CreateBinRequest;

@RestController
@RequestMapping("/api/cabinets/{cabinetId}/bins")
public class BinController {
    private final BinService binService;

    public BinController(BinService binService) {
        this.binService = binService;
    }

    @GetMapping
    public List<BinResponse> getBinsByCabinetId(@PathVariable Long cabinetId) {
        return binService.getBinsByCabinetId(cabinetId)
            .stream()
            .map(bin -> new BinResponse(
                bin.getId(),
                bin.getName(),
                bin.getShelfCode(),
                bin.getBinNumber(),
                bin.getDescription(),
                bin.getCabinet().getId()
            ))
            .toList();
    }

    @PostMapping
    public BinResponse createBin(@PathVariable Long cabinetId, @RequestBody CreateBinRequest request) {
        Bin bin = binService.createBin(cabinetId, request.name(), request.shelfCode(), request.binNumber(), request.description());

        BinResponse br = new BinResponse(bin.getId(), bin.getName(), bin.getShelfCode(), bin.getBinNumber(), bin.getDescription(), bin.getCabinet().getId());

        return br;
    }

}
