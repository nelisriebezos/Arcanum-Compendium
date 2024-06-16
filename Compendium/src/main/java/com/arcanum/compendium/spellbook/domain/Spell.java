package com.arcanum.compendium.spellbook.domain;

import com.arcanum.compendium.spellbook.service.converter.ComponentConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Spell extends Ability {
    private Level level;
    private String castingTime;
    private String range;
    private String school;
    @Convert(converter = ComponentConverter.class)
    private Set<Component> components = new HashSet<>();
    private String material;
    private String duration;
    private String higherLevel;

    @Builder(builderMethodName = "spellBuilder")
    public Spell(UUID uuid, String name, String description, Level level, String castingTime, String range, String school, Set<Component> components, String material, String duration, String higherLevel) {
        super(uuid, name, description);
        this.level = level;
        this.castingTime = castingTime;
        this.range = range;
        this.school = school;
        this.components = components;
        this.material = material;
        this.duration = duration;
        this.higherLevel = higherLevel;
    }
}
