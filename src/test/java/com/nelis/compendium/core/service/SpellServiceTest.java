package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.SpellRepository;
import com.nelis.compendium.core.domain.spells.Spell;
import com.nelis.compendium.core.service.exception.SpellNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class SpellServiceTest {
    @Autowired
    private SpellService spellService;
    @Autowired
    private SpellRepository spellRepository;

    private Spell testSpell;

    @BeforeEach
    void setUp() {
        spellRepository.deleteAll();

        testSpell = Spell.builder()
                .name("Test Spell")
                .build();
    }

    @Test
    void persistSpell() {
        Spell persistedSpell = spellService.persistSpell(testSpell);
        assertEquals(testSpell, persistedSpell);
    }

    @Test
    void getSpellById() {
        Spell persistedSpell = spellService.persistSpell(testSpell);
        Spell retrievedSpell = spellService.getSpellById(persistedSpell.getUuid());
        assertEquals(persistedSpell, retrievedSpell);
    }

    @Test
    void deleteSpell() {
        Spell persistedSpell = spellService.persistSpell(testSpell);
        spellService.deleteSpell(persistedSpell.getUuid());
        assertEquals(0, spellRepository.count());
    }

    @Test
    void getSpellByIdNotFound() {
        assertThrows(SpellNotFound.class, () -> spellService.getSpellById(UUID.randomUUID()));
    }
}