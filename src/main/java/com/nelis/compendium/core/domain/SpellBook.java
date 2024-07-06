package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.spells.Spell;
import com.nelis.compendium.core.domain.spells.SpellSlot;
import com.nelis.compendium.core.domain.skills.SkillType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SpellBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Builder.Default
    private SkillType spellCastingAbility = null;
    private int spellSaveDC;
    private int spellAttackBonus;
    @OneToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private ArrayList<Spell> spells = new ArrayList<>();

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void removeSpell(Spell spell) {
        spells.remove(spell);
    }

    public ArrayList<Spell> getAllSpellsOfSpellslot(SpellSlot spellSlot) {
        ArrayList<Spell> filteredList = new ArrayList<>();
        for (Spell spell : spells) {
            if (spell.getSpellSlot() == spellSlot) {
                filteredList.add(spell);
            }
        }
        return filteredList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpellBook spellBook = (SpellBook) o;
        return Objects.equals(uuid, spellBook.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }
}
