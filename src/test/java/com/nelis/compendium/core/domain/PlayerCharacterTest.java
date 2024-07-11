package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.exception.SkillNotFound;
import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.Skill;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static com.nelis.compendium.core.domain.skills.SkillName.*;
import static com.nelis.compendium.core.domain.skills.SkillType.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {
    private PlayerCharacter testPlayerCharacter;
    private Skill stealth;

    @BeforeEach
    void setUp() {
        MainSkill strength = MainSkill.builder()
                .uuid(UUID.randomUUID())
                .name(STRENGTH)
                .modifier(2)
                .build();

        MainSkill dexterity = MainSkill.builder()
                .uuid(UUID.randomUUID())
                .name(DEXTERITY)
                .modifier(4)
                .build();

        stealth = Skill.builder()
                .name(STEALTH)
                .build();

        Skill acrobatics = Skill.builder()
                .name(ACROBATICS)
                .build();

        testPlayerCharacter = PlayerCharacter.builder()
                .mainSkills(Set.of(strength, dexterity))
                .skills(Set.of(stealth, acrobatics))
                .build();
    }

    @Test
    void getMainSkillModifier() {
        int modifier = testPlayerCharacter.getMainSkillModifier(DEXTERITY);
        assertEquals(4, modifier);
    }

    @Test
    void getSkillByName() {
        Skill fetchedSkill = testPlayerCharacter.getSkillByName(STEALTH);
        assertEquals(stealth, fetchedSkill);
    }

    @Test
    void getSkillByNameNotFound() {
        assertThrows(SkillNotFound.class, () -> testPlayerCharacter.getSkillByName(ACROBATICS));
    }
}