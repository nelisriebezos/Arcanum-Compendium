package com.nelis.compendium.core.domain.skills;

import com.nelis.compendium.core.domain.PlayerCharacter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    private SkillName name;
    private int modifier = 0;
    @Enumerated(EnumType.STRING)
    private SkillType skillType;
    private boolean isProficient = false;
    @ManyToOne
    @JoinColumn(name = "player_character_id")
    private PlayerCharacter playerCharacter;

    public Skill(SkillName name, SkillType skillType, boolean isProficient, PlayerCharacter playerCharacter) {
        this.name = name;
        this.skillType = skillType;
        this.isProficient = isProficient;
        this.playerCharacter = playerCharacter;
        setSkillBaseModifiers();
        if (isProficient) {
            modifier += playerCharacter.getProficiencyBonus();
        }
    }

    public boolean isProficient() {
        return isProficient;
    }

    public void triggerProficiency() {
        if (!isProficient) {
            isProficient = true;
            modifier += playerCharacter.getProficiencyBonus();
        } else {
            isProficient = false;
            modifier -= playerCharacter.getProficiencyBonus();
        }
    }

    public void setSkillBaseModifiers() {
        modifier = playerCharacter.getMainSkillModifier(getSkillType());
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Skill skill = (Skill) o;
        return getUuid() != null && Objects.equals(getUuid(), skill.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
