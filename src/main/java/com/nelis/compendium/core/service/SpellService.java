package com.nelis.compendium.core.service;

import com.nelis.compendium.core.domain.spells.Spell;
import com.nelis.compendium.core.data.SpellRepository;
import com.nelis.compendium.core.service.exception.SpellNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
