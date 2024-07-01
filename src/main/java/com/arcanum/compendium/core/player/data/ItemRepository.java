package com.arcanum.compendium.core.player.data;

import com.arcanum.compendium.core.player.domain.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
