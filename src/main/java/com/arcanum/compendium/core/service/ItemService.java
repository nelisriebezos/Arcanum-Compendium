package com.arcanum.compendium.core.service;

import com.arcanum.compendium.core.data.ItemRepository;
import com.arcanum.compendium.core.domain.items.Item;
import com.arcanum.compendium.core.service.exception.ItemNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemService {
    private static final Logger logger = LogManager.getLogger();

    private final ItemRepository itemRepository;

    public <T extends Item> T persistItem(T item) {
        logger.info("Persisting Item of type: " + item.getClass() + "  with id: " + item.getUuid());
        return itemRepository.save(item);
    }

    public Item getItemById(UUID id) {
        logger.info("Retrieving Item with id: " + id);
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    public void deleteItem(UUID id) {
        logger.info("Deleting Item with id: " + id);
        itemRepository.deleteById(id);
    }
}
