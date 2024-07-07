package com.nelis.compendium.core.domain.spells;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
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
    @Enumerated(EnumType.STRING)
    private SpellSlot spellSlot;
    @Enumerated(EnumType.STRING)
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
    @ElementCollection
    @Builder.Default
    private List<String> materialComponents = new ArrayList<>();
    private String higherLevelDescription;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Spell spell = (Spell) o;
        return getUuid() != null && Objects.equals(getUuid(), spell.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
