package com.yogipatel.inventory.room;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yogipatel.inventory.room.dto.BinPreviewResponse;
import com.yogipatel.inventory.room.dto.CabinetPreviewResponse;
import com.yogipatel.inventory.room.dto.ItemPreviewResponse;
import com.yogipatel.inventory.room.dto.RoomPreviewResponse;
import com.yogipatel.inventory.room.dto.StructurePreviewResponse;


@RestController
public class RoomPreviewController {
    @GetMapping("/api/structure-preview")
    public StructurePreviewResponse getStructurePreview() {
        ItemPreviewResponse glueSticks = new ItemPreviewResponse("Glue Sticks", 1);

        BinPreviewResponse adhesiveBin = new BinPreviewResponse("Adhesive Bin", List.of(glueSticks));

        CabinetPreviewResponse sideCabinet = new CabinetPreviewResponse("Shishu Mandal Side Cabinet", List.of(adhesiveBin));

        CabinetPreviewResponse bookshelfCabinet = new CabinetPreviewResponse("Shishu Mandal Bookshelf", List.of());

        RoomPreviewResponse smRoom = new RoomPreviewResponse("Shishu Mandal", List.of(sideCabinet, bookshelfCabinet));

        return new StructurePreviewResponse(List.of(smRoom));
    }
}