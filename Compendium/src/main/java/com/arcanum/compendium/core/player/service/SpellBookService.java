package com.arcanum.compendium.core.player.service;

import com.arcanum.compendium.core.player.data.SpellBookRepository;
import com.arcanum.compendium.core.player.data.SpellRepository;
import com.arcanum.compendium.core.player.domain.Spell;
import com.arcanum.compendium.core.player.domain.SpellBook;
import com.arcanum.compendium.core.player.service.exception.SpellBookNotFound;
import com.arcanum.compendium.core.player.service.exception.SpellNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SpellBookService {
    private static final Logger logger = LogManager.getLogger();

    private final SpellBookRepository spellBookRepository;
    private final SpellRepository spellRepository;

    public SpellBook saveSpellBook(SpellBook spellBook) {
        logger.info("Saving spellBook: " + spellBook.getUuid());
        return spellBookRepository.save(spellBook);
    }

    public SpellBook addSpellToSpellBook(UUID spellBookId, UUID spellId) {
        SpellBook spellBook = spellBookRepository.findById(spellBookId)
                .orElseThrow(() -> new SpellBookNotFound("SpellBook not found with id: " + spellBookId));
        Spell spell = spellRepository.findById(spellId)
                .orElseThrow(() -> new SpellNotFound("Spell not found with id: " + spellId));
        spellBook.addSpell(spell);
        return saveSpellBook(spellBook);
    }
}
