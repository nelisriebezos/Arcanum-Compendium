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
public class MainSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Enumerated(EnumType.STRING)
    private SkillType name;
    @Column(name = "main_skill_value")
    private int value = 0;
    private int modifier = 0;
    @ManyToOne
    @JoinColumn(name = "player_character_uuid")
    private PlayerCharacter playerCharacter;

    public void calculateSkillModifier() {
        if (value == 1) setModifier(-5);
        else if (value > 1 && value < 4) setModifier(-4);
        else if (value > 3 && value < 6) setModifier(-3);
        else if (value > 5 && value < 8) setModifier(-2);
        else if ( value > 7 && value < 10) setModifier(-1);
        else if ( value > 9 && value < 12) setModifier(0);
        else if ( value > 11 && value < 14) setModifier(1);
        else if ( value > 13 && value < 16) setModifier(2);
        else if ( value > 15 && value < 18) setModifier(3);
        else if ( value > 17 && value < 20) setModifier(4);
        else if ( value > 19 && value < 22) setModifier(5);
        else if ( value > 21 && value < 24) setModifier(6);
        else if ( value > 23 && value < 26) setModifier(7);
        else if ( value > 25 && value < 28) setModifier(8);
        else if ( value > 27 && value < 30) setModifier(9);
        else if (value == 30) setModifier(10);
    }
    
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        MainSkill student = (MainSkill) o;
        return getUuid() != null && Objects.equals(getUuid(), student.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();     }
}
