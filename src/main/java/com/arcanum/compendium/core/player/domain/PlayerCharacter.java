package com.arcanum.compendium.core.player.domain;

import com.arcanum.compendium.core.player.domain.skills.MainStat;
import com.arcanum.compendium.core.player.domain.skills.Skill;
import com.arcanum.compendium.core.player.domain.skills.SkillType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class PlayerCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    @OneToOne
    private Inventory inventory;
    @OneToOne
    private SpellBook spellBook;
    @OneToOne
    private RpSheet rpSheet;
    @OneToMany
    @Builder.Default
    private Set<MainStat> mainStats = new HashSet<>();
    @OneToMany
    @Builder.Default
    private Set<Skill> skills = new HashSet<>();
    @OneToOne
    private HealthStatus healthStatus;
    private String playerClass;
    private int speed;
    private int level;
    private int proficiencyBonus;
    private int initiative;

}
