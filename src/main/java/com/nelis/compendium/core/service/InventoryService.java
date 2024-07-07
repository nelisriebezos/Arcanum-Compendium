package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.InventoryRepository;
import com.nelis.compendium.core.domain.Inventory;
import com.nelis.compendium.core.service.exception.InventoryNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InventoryService {
    private static final Logger logger = LogManager.getLogger();
    private final InventoryRepository inventoryRepository;

    public Inventory persistInventory(Inventory inventory) {
        logger.info("Persisting Inventory with id: " + inventory.getUuid());
        return inventoryRepository.save(inventory);
    }

    public Inventory getInventoryById(UUID id) {
        logger.info("Retrieving Inventory with id: " + id);
        return inventoryRepository.findById(id).orElseThrow(() -> new InventoryNotFound(id));
    }
}
