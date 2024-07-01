package com.arcanum.compendium.core.player.service;

import com.arcanum.compendium.core.player.domain.spells.Spell;
import com.arcanum.compendium.core.player.data.SpellRepository;
import com.arcanum.compendium.core.player.service.exception.SpellNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SpellService {
    private static final Logger logger = LogManager.getLogger();

    private final SpellRepository spellRepository;

    public Spell persistSpell(Spell spell) {
        logger.info("Persisting spell with id: " + spell.getUuid());
        return spellRepository.save(spell);
    }

    public Spell getSpellById(UUID id) {
        logger.info("Retrieving Spell with id: " + id);
        return spellRepository.findById(id).orElseThrow(() -> new SpellNotFound(id));
    }

    public void deleteSpell(UUID id) {
        logger.info("Deleting Spell with id: " + id);
        spellRepository.deleteById(id);
    }
}
