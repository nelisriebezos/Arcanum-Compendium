package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class SpellBook {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @OneToMany(fetch = FetchType.EAGER)
    private ArrayList<Spell> spells = new ArrayList<>();

    public void addSpell(Spell spell) {
        spells.add(spell);
    }

    public void removeSpell(Spell spell) {
        spells.remove(spell);
    }

    public ArrayList<Spell> getAllSpellsOfType(SpellSlot spellSlot) {
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
