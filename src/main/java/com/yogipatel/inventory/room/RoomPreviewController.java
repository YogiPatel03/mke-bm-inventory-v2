package com.yogipatel.inventory.room;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RoomPreviewController {
    @GetMapping("api/structure-preview")
    public Map<String, Object> getStructurePreview() {

        Map<String, Object> glueSticks = Map.of("name", "Glue Sticks", "quantityAvailable", 1);

        Map<String, Object> adhesiveBin = Map.of("name", "Adhesive Bin", "items", List.of(glueSticks));

        Map<String, Object> sideCabinet = Map.of("name", "Shishu Mandal Side Cabinet", "bins", List.of(adhesiveBin));

        Map<String, Object> bookshelfCabinet = Map.of("name", "Shishu Mandal Bookshelf", "bins", List.of());

       Map<String, Object> room = Map.of("name", "Shishu Mandal", "cabinets", List.of(sideCabinet, bookshelfCabinet));

        return Map.of("rooms", List.of(room));
    }
}