//package com.nelis.compendium.core.service;
//
//import com.nelis.compendium.core.data.SpellBookRepository;
//import com.nelis.compendium.core.domain.SpellBook;
//import lombok.AllArgsConstructor;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class SpellBookService {
//    private static final Logger logger = LogManager.getLogger();
//
//    private final SpellBookRepository spellBookRepository;
//    private final SpellService spellService;
//
//    public SpellBook persistSpellBook(SpellBook spellBook) {
//        logger.info("Persisting SpellBook with id: " + spellBook.getUuid());
//        return spellBookRepository.save(spellBook);
//    }
//
////    public SpellBook addSpellToSpellBook(SpellBook spellBook, Spell spell) {
////        spellBook.addSpell(spell);
////
////    }
////
////    public SpellBook addSpellToSpellBook(UUID spellBookId, UUID spellId) {
////        SpellBook spellBook = spellBookRepository.findById(spellBookId)
////                .orElseThrow(() -> new SpellBookNotFound(spellBookId));
////
////        Spell spell = spellRepository.findById(spellId)
////                .orElseThrow(() -> new SpellNotFound(spellId));
////        spellBook.addSpell(spell);
////        return persistSpellBook(spellBook);
////    }
//}
