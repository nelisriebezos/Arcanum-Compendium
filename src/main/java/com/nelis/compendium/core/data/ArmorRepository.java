package com.nelis.compendium.core.data;

import com.nelis.compendium.core.domain.items.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArmorRepository extends JpaRepository<Armor, UUID> {
}
