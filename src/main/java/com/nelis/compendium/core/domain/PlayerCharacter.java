package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.Skill;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

//    @OneToOne(cascade = CascadeType.ALL)
//    private SpellBook spellBook;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private RpSheet rpSheet;
//
//    @OneToMany(cascade = CascadeType.ALL,
//    mappedBy = "playerCharacter")
//    @Builder.Default
//    private Set<MainSkill> mainStats = new HashSet<>();
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @Builder.Default
//    private Set<Skill> skills = new HashSet<>();
//
//    @OneToOne(cascade = CascadeType.ALL)
//    private HealthStatus healthStatus;

    private String playerClass;
    private int speed;
    private int level;
    private int proficiencyBonus;
    private int initiative;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PlayerCharacter student = (PlayerCharacter) o;
        return getUuid() != null && Objects.equals(getUuid(), student.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();     }
}
