package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.*;
import com.nelis.compendium.core.domain.skills.Skill;
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
    @Autowired
    private SpellBookRepository spellBookRepository;
    @Autowired
    private RpSheetRepository rpSheetRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private HealthStatusRepository healthStatusRepository;

    private PlayerCharacter testPlayerCharacter;
    private Inventory testInventory;
    private SpellBook testSpellBook;
    private RpSheet testRpSheet;
    private Skill testSkill;
    private HealthStatus testHealthStatus;

    @BeforeEach
    void setUp() {
        playerCharacterRepository.deleteAll();
        inventoryRepository.deleteAll();
        spellBookRepository.deleteAll();
        rpSheetRepository.deleteAll();
        skillRepository.deleteAll();
        healthStatusRepository.deleteAll();

        testPlayerCharacter = PlayerCharacter.builder()
                .name("Test PlayerCharacter")
                .build();

        testInventory = Inventory.builder()
                .playerCharacter(testPlayerCharacter)
                .build();

        testSpellBook = SpellBook.builder()
                .playerCharacter(testPlayerCharacter)
                .build();

        testRpSheet = RpSheet.builder()
                .playerCharacter(testPlayerCharacter)
                .build();

        testSkill = Skill.builder()
                .playerCharacter(testPlayerCharacter)
                .build();

        testHealthStatus = HealthStatus.builder()
                .playerCharacter(testPlayerCharacter)
                .build();

        testPlayerCharacter.setInventory(testInventory);
        testPlayerCharacter.setSpellBook(testSpellBook);
        testPlayerCharacter.setRpSheet(testRpSheet);
        testPlayerCharacter.setSkills(Set.of(testSkill));
        testPlayerCharacter.setHealthStatus(testHealthStatus);
    }

    @Test
    void persistPlayerCharacter() {
        testPlayerCharacter = playerCharacterService.persistPlayerCharacter(testPlayerCharacter);
        assertNotNull(playerCharacterRepository.findById(testPlayerCharacter.getUuid()));
        assertNotNull(inventoryRepository.findById(testPlayerCharacter.getInventory().getUuid()));
        assertNotNull(spellBookRepository.findById(testPlayerCharacter.getSpellBook().getUuid()));
        assertNotNull(rpSheetRepository.findById(testPlayerCharacter.getRpSheet().getUuid()));
        assertNotNull(skillRepository.findById(testPlayerCharacter.getSkills().iterator().next().getUuid()));
        assertNotNull(healthStatusRepository.findById(testPlayerCharacter.getHealthStatus().getUuid()));
    }

    @Test
    void getPlayerCharacterById() {
    }

    @Test
    void deletePlayerCharacter() {
    }
}