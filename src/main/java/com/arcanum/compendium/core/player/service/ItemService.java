package com.arcanum.compendium.core.player.service;

import com.arcanum.compendium.core.player.data.ItemRepository;
import com.arcanum.compendium.core.player.domain.items.Item;
import com.arcanum.compendium.core.player.service.exception.ItemNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public <T extends Item> T persistItem(T item) {
        return itemRepository.save(item);
    }

    public Item getItemById(UUID id) {
        return itemRepository.findById(id).orElseThrow(() -> new ItemNotFound(id));
    }

    public void deleteItem(UUID id) {
        itemRepository.deleteById(id);
    }


}
