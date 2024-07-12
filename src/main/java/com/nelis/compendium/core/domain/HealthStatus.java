package com.nelis.compendium.core.domain;

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
public class HealthStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private int armorClass = 0;
    private int hp = 0;
    private int maxHp = 0;
    private int tempHp = 0;
    private int posDeathSaves = 0;
    private int negDeathSaves = 0;
    private String hitDice = "";
    private int availableHitDice = 0;

    public HealthStatus(int armorClass, int hp, int maxHp, int tempHp, int posDeathSaves, int negDeathSaves, String hitDice, int availableHitDice) {
        this.armorClass = armorClass;
        this.hp = hp;
        this.maxHp = maxHp;
        this.tempHp = tempHp;
        this.posDeathSaves = posDeathSaves;
        this.negDeathSaves = negDeathSaves;
        this.hitDice = hitDice;
        this.availableHitDice = availableHitDice;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        HealthStatus healthStatus = (HealthStatus) o;
        return getUuid() != null && Objects.equals(getUuid(), healthStatus.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
