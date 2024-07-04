package com.arcanum.compendium.core.data;

import com.arcanum.compendium.core.domain.SpellBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpellBookRepository extends JpaRepository<SpellBook, UUID> {
}
