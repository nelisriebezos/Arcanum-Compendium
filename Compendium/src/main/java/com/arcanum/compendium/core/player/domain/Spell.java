package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private SpellSlot spellSlot;
    private MagicSchool magicSchool;
    private String name;
    private String description;
    private String castingTime;
    private String range;
    private String duration;
    private boolean ritual = false;
    private boolean concentration = false;
    private boolean verbal = false;
    private boolean somatic = false;
    private boolean material = false;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private ArrayList<String> materialComponents = new ArrayList<>();
    private String higherLevelDescription;
    @ManyToOne(fetch = FetchType.LAZY)
    private SpellBook spellBook;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spell spell = (Spell) o;
        return Objects.equals(uuid, spell.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    @Override
    public String toString() {
        return "Spell{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                '}';
    }
}
