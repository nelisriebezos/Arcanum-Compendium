package com.nelis.compendium.core.domain.skills;

import lombok.Getter;

@Getter
public enum SkillType {
    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    CONSTITUTION("Constitution"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    CHARISMA("Charisma");

    private final String value;

    SkillType(String value) {
        this.value = value;
    }
}
