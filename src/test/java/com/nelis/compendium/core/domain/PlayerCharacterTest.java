package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.SkillType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.UUID;

import static com.nelis.compendium.core.domain.skills.SkillType.DEXTERITY;
import static com.nelis.compendium.core.domain.skills.SkillType.STRENGTH;
import static org.junit.jupiter.api.Assertions.*;

class PlayerCharacterTest {
    private PlayerCharacter testPlayerCharacter;

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

        testPlayerCharacter = PlayerCharacter.builder()
                .mainSkills(Set.of(strength, dexterity))
                .build();
    }

    @Test
    void getMainSkillModifier() {
        int modifier = testPlayerCharacter.getMainSkillModifier(DEXTERITY);
        assertEquals(4, modifier);
    }
}