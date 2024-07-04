package com.arcanum.compendium.core.data;

import com.arcanum.compendium.core.domain.items.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ItemRepository extends JpaRepository<Item, UUID> {
}
