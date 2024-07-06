package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.spells.Spell;
import com.nelis.compendium.core.domain.spells.SpellSlot;
import com.nelis.compendium.core.domain.skills.SkillType;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
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
    private List<Spell> spells = new ArrayList<>();
    @OneToOne
    private PlayerCharacter playerCharacter;

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
        if (!(o instanceof SpellBook spellBook)) return false;
        return spellSaveDC == spellBook.spellSaveDC && spellAttackBonus == spellBook.spellAttackBonus && Objects.equals(uuid, spellBook.uuid) && spellCastingAbility == spellBook.spellCastingAbility && Objects.equals(spells, spellBook.spells) && Objects.equals(playerCharacter, spellBook.playerCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, spellCastingAbility, spellSaveDC, spellAttackBonus, spells, playerCharacter);
    }
}
