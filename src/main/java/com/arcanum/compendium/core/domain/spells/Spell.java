package com.arcanum.compendium.core.domain.spells;

import com.arcanum.compendium.core.domain.SpellBook;
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
    @Builder.Default
    private boolean ritual = false;
    @Builder.Default
    private boolean concentration = false;
    @Builder.Default
    private boolean verbal = false;
    @Builder.Default
    private boolean somatic = false;
    @Builder.Default
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
        if (!(o instanceof Spell spell)) return false;
        return ritual == spell.ritual && concentration == spell.concentration && verbal == spell.verbal && somatic == spell.somatic && material == spell.material && Objects.equals(uuid, spell.uuid) && spellSlot == spell.spellSlot && magicSchool == spell.magicSchool && Objects.equals(name, spell.name) && Objects.equals(description, spell.description) && Objects.equals(castingTime, spell.castingTime) && Objects.equals(range, spell.range) && Objects.equals(duration, spell.duration) && Objects.equals(materialComponents, spell.materialComponents) && Objects.equals(higherLevelDescription, spell.higherLevelDescription) && Objects.equals(spellBook, spell.spellBook);
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
