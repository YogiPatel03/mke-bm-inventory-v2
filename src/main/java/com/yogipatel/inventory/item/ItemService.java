package com.yogipatel.inventory.item;

import com.yogipatel.inventory.bin.Bin;
import com.yogipatel.inventory.bin.BinRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final BinRepository binRepository;

    public ItemService(ItemRepository itemRepository, BinRepository binRepository) {
        this.itemRepository = itemRepository;
        this.binRepository = binRepository;
    }

    public List<Item> getItemsByBinId(Long binId) {
        return itemRepository.findByBinIdOrderByNameAsc(binId);
    }

    public Item createItem(Long binId, String name, String sku, Integer quantityAvailable, Integer lowStockThreshold, String description) {
        Bin bin = binRepository.findById(binId).orElseThrow(() -> new IllegalArgumentException("bin (" + binId + ") does not exist."));
        Item item = new Item(name, sku,  quantityAvailable, lowStockThreshold, description, bin);
        return itemRepository.save(item);
    }
}
