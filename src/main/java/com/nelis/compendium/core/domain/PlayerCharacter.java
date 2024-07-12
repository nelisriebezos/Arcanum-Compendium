package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.exception.SkillNotFound;
import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.Skill;
import com.nelis.compendium.core.domain.skills.SkillName;
import com.nelis.compendium.core.domain.skills.SkillType;
import com.nelis.compendium.core.domain.spells.Spell;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToMany(fetch = FetchType.EAGER)
    @Builder.Default
    private List<Spell> spells = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private RpSheet rpSheet;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "playerCharacter")
    @Builder.Default
    private Set<MainSkill> mainSkills = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "playerCharacter")
    @Builder.Default
    private Set<Skill> skills = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private HealthStatus healthStatus;

    private String playerClass = "";
    private int speed = 0;
    private int level = 0;
    private int proficiencyBonus = 0;
    private int initiative = 0;

    public PlayerCharacter(String playerClass, int speed, int level, int proficiencyBonus, int initiative) {
        this.playerClass = playerClass;
        this.speed = speed;
        this.level = level;
        this.proficiencyBonus = proficiencyBonus;
        this.initiative = initiative;
    }

    public String getName() {
        return rpSheet.getName();
    }

    public int getMainSkillModifier(SkillType type) {
        for (MainSkill mainSkill : mainSkills) {
            if (mainSkill.getName().equals(type)) {
                return mainSkill.getModifier();
            }
        }
        throw new SkillNotFound(type.name());
    }

//    TODO: test
    public List<Skill> getSkillsByType(SkillType type) {
        List<Skill> skillsByType = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getSkillType().equals(type)) {
                skillsByType.add(skill);
            }
        }
        return skillsByType;
    }

    public Skill getSkillByName(SkillName skillName) {
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)) {
                return skill;
            }
        }
        throw new SkillNotFound(skillName.name());
    }


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
                : getClass().hashCode();
    }
}
