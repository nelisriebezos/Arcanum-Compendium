package com.arcanum.compendium.spellbook.domain;

import Level.Level;
import com.arcanum.compendium.spellbook.service.converter.ComponentConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


}
