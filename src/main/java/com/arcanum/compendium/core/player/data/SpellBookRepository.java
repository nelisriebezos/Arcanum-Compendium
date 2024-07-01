package com.arcanum.compendium.core.player.data;

import com.arcanum.compendium.core.player.domain.SpellBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpellBookRepository extends JpaRepository<SpellBook, UUID> {
}
