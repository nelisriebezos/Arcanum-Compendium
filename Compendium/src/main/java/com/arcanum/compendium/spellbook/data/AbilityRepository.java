package com.arcanum.compendium.spellbook.data;

import com.arcanum.compendium.spellbook.domain.Ability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbilityRepository extends JpaRepository<Ability, UUID> {
}
