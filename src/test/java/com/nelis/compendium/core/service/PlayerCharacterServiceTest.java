package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.*;
import com.nelis.compendium.core.domain.spells.Spell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class PlayerCharacterServiceTest {
    @Autowired
    private PlayerCharacterService playerCharacterService;
    @Autowired
    private PlayerCharacterRepository playerCharacterRepository;
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private SpellRepository spellRepository;
//    @Autowired
//    private RpSheetRepository rpSheetRepository;
//    @Autowired
//    private SkillRepository skillRepository;
//    @Autowired
//    private MainSkillRepository mainSkillRepository;
//    @Autowired
//    private HealthStatusRepository healthStatusRepository;

    private PlayerCharacter testPlayerCharacter;

    @BeforeEach
    void setUp() {
        spellRepository.deleteAll();

        playerCharacterRepository.deleteAll();
//        inventoryRepository.deleteAll();
//        rpSheetRepository.deleteAll();
//        skillRepository.deleteAll();
//        healthStatusRepository.deleteAll();

        testPlayerCharacter = PlayerCharacter.builder()
                .name("Test PlayerCharacter")
                .build();

        Inventory testInventory = Inventory.builder()
                .gold(100)
                .build();

        Spell testSpell = Spell.builder()
                .name("Test Spell")
                .build();

//        RpSheet testRpSheet = RpSheet.builder()
//                .playerCharacter(testPlayerCharacter)
//                .build();
//
//        MainStat testMainStat = MainStat.builder()
//                .playerCharacter(testPlayerCharacter)
//                .build();
//
//        Skill testSkill = Skill.builder()
//                .playerCharacter(testPlayerCharacter)
//                .build();
//
//        HealthStatus testHealthStatus = HealthStatus.builder()
//                .playerCharacter(testPlayerCharacter)
//                .build();

        testSpell = spellRepository.save(testSpell);

        testPlayerCharacter.setInventory(testInventory);
        testPlayerCharacter.setSpells(List.of(testSpell));
//        testPlayerCharacter.setSpellBook(testSpellBook);
//        testPlayerCharacter.setRpSheet(testRpSheet);
//        testPlayerCharacter.setMainStats(Set.of(testMainStat));
//        testPlayerCharacter.setSkills(Set.of(testSkill));
//        testPlayerCharacter.setHealthStatus(testHealthStatus);


    }

    @Test
    void persistPlayerCharacter() {
        PlayerCharacter playerCharacter = playerCharacterService.persistPlayerCharacter(testPlayerCharacter);
        assertNotNull(playerCharacter);
        assertNotNull(playerCharacter.getUuid());
        assertEquals(testPlayerCharacter, playerCharacter);
        assertEquals(testPlayerCharacter.getInventory(), playerCharacter.getInventory());
        assertEquals(testPlayerCharacter.getSpells(), playerCharacter.getSpells());
    }

    @Test
    void getPlayerCharacterById() {
        testPlayerCharacter = playerCharacterService.persistPlayerCharacter(testPlayerCharacter);

        PlayerCharacter fetchedCharacter = playerCharacterService.getPlayerCharacterById(testPlayerCharacter.getUuid());
        assertEquals(testPlayerCharacter, fetchedCharacter);
        assertEquals(testPlayerCharacter.getInventory(), fetchedCharacter.getInventory());

//        assertEquals(testPlayerCharacter.getSpellBook(), fetchedCharacter.getSpellBook());
//        assertEquals(testPlayerCharacter.getRpSheet(), fetchedCharacter.getRpSheet());
//        assertEquals(testPlayerCharacter.getMainStats(), fetchedCharacter.getMainStats());
//        assertEquals(testPlayerCharacter.getSkills(), fetchedCharacter.getSkills());
//        assertEquals(testPlayerCharacter.getHealthStatus(), fetchedCharacter.getHealthStatus());
    }

    @Test
    void deletePlayerCharacter() {
        testPlayerCharacter = playerCharacterService.persistPlayerCharacter(testPlayerCharacter);
        playerCharacterService.deletePlayerCharacter(testPlayerCharacter.getUuid());

        assertEquals(0, playerCharacterRepository.count());
        assertEquals(0, inventoryRepository.count());
    }
}