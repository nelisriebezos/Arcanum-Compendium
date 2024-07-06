package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.spells.Spell;
import com.nelis.compendium.core.domain.spells.SpellSlot;
import com.nelis.compendium.core.domain.skills.SkillType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SpellBook spellBook = (SpellBook) o;
        return getUuid() != null && Objects.equals(getUuid(), spellBook.getUuid());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
