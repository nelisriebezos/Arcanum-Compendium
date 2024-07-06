package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.skills.MainStat;
import com.nelis.compendium.core.domain.skills.Skill;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
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

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private SpellBook spellBook;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private RpSheet rpSheet;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Builder.Default
    private Set<MainStat> mainStats = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Skill> skills = new HashSet<>();

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private HealthStatus healthStatus;

    private String playerClass;
    private int speed;
    private int level;
    private int proficiencyBonus;
    private int initiative;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerCharacter that)) return false;
        return speed == that.speed && level == that.level && proficiencyBonus == that.proficiencyBonus && initiative == that.initiative && Objects.equals(uuid, that.uuid) && Objects.equals(name, that.name) && Objects.equals(inventory, that.inventory) && Objects.equals(spellBook, that.spellBook) && Objects.equals(rpSheet, that.rpSheet) && Objects.equals(mainStats, that.mainStats) && Objects.equals(skills, that.skills) && Objects.equals(healthStatus, that.healthStatus) && Objects.equals(playerClass, that.playerClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, inventory, spellBook, rpSheet, mainStats, skills, healthStatus, playerClass, speed, level, proficiencyBonus, initiative);
    }
}
