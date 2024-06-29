package com.arcanum.compendium.core.player.service;

import com.arcanum.compendium.core.player.domain.Spell;
import com.arcanum.compendium.environment.Workspace;
import com.arcanum.compendium.core.player.data.SpellRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SpellService {
    private static final Logger logger = LogManager.getLogger();

    private final SpellRepository spellRepository;

    public Spell saveSpell(Spell spell) {
        logger.info("Saving spell: " + spell.getUuid());
        return spellRepository.save(spell);
    }
}
