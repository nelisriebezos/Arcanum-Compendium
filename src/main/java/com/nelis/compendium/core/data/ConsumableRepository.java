package com.nelis.compendium.core.data;

import com.nelis.compendium.core.domain.items.Armor;
import com.nelis.compendium.core.domain.items.Consumable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsumableRepository extends JpaRepository<Consumable, UUID> {
}
