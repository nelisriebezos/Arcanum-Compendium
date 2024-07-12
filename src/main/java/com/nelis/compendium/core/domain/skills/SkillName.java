package com.nelis.compendium.core.domain.skills;

import lombok.Getter;

@Getter
public enum SkillName {
    STRENGTH_ST("Strength saving throw"),
    DEXTERITY_ST("Dexterity saving throw"),
    CONSTITUTION_ST("Constitution saving throw"),
    INTELLIGENCE_ST("Intelligence saving throw"),
    WISDOM_ST("Wisdom saving throw"),
    CHARISMA_ST("Charisma saving throw"),
    ACROBATICS("Acrobatics"),
    ANIMAL_HANDLING("Animal Handling"),
    ARCANA("Arcana"),
    ATHLETICS("Athletics"),
    DECEPTION("Deception"),
    HISTORY("History"),
    INSIGHT("Insight"),
    INTIMIDATION("Intimidation"),
    INVESTIGATION("Investigation"),
    MEDICINE("Medicine"),
    NATURE("Nature"),
    PERCEPTION("Perception"),
    PERFORMANCE("Performance"),
    PERSUASION("Persuasion"),
    RELIGION("Religion"),
    SLEIGHT_OF_HAND("Sleight of Hand"),
    STEALTH("Stealth"),
    SURVIVAL("Survival");

    private final String value;

    SkillName(String value) {
        this.value = value;
    }
}
