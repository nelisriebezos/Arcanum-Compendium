package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
//    @Autowired
//    private SpellBookRepository spellBookRepository;
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
        playerCharacterRepository.deleteAll();
        inventoryRepository.deleteAll();
//        spellBookRepository.deleteAll();
//        rpSheetRepository.deleteAll();
//        skillRepository.deleteAll();
//        healthStatusRepository.deleteAll();

        testPlayerCharacter = PlayerCharacter.builder()
                .name("Test PlayerCharacter")
                .build();

        Inventory testInventory = Inventory.builder()
//                .playerCharacter(testPlayerCharacter)
                .build();

//        SpellBook testSpellBook = SpellBook.builder()
//                .playerCharacter(testPlayerCharacter)
//                .build();
//
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

        testPlayerCharacter.setInventory(testInventory);
//        testPlayerCharacter.setSpellBook(testSpellBook);
//        testPlayerCharacter.setRpSheet(testRpSheet);
//        testPlayerCharacter.setMainStats(Set.of(testMainStat));
//        testPlayerCharacter.setSkills(Set.of(testSkill));
//        testPlayerCharacter.setHealthStatus(testHealthStatus);

        System.out.println("Finished the setup\n");
    }

    @Test
    void persistPlayerCharacter() {
        testPlayerCharacter = playerCharacterService.persistPlayerCharacter(testPlayerCharacter);
        assertNotNull(playerCharacterRepository.findById(testPlayerCharacter.getUuid()));
        assertNotNull(inventoryRepository.findById(testPlayerCharacter.getInventory().getUuid()));


//        assertNotNull(spellBookRepository.findById(testPlayerCharacter.getSpellBook().getUuid()));
//        assertNotNull(rpSheetRepository.findById(testPlayerCharacter.getRpSheet().getUuid()));
//        assertNotNull(mainStatRepository.findById(testPlayerCharacter.getMainStats().iterator().next().getUuid()));
//        assertNotNull(skillRepository.findById(testPlayerCharacter.getSkills().iterator().next().getUuid()));
//        assertNotNull(healthStatusRepository.findById(testPlayerCharacter.getHealthStatus().getUuid()));
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
    }
}