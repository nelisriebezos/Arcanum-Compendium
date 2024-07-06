package com.nelis.compendium.core.domain;

import jakarta.persistence.*;
import lombok.*;

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
    private int armorClass;
    private int hp;
    private int maxHp;
    private int tempHp;
    private int posDeathSaves;
    private int negDeathSeaves;
    private String hitDice;
    private int availableHitDice;
    @OneToOne
    private PlayerCharacter playerCharacter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HealthStatus that)) return false;
        return armorClass == that.armorClass && hp == that.hp && maxHp == that.maxHp && tempHp == that.tempHp && posDeathSaves == that.posDeathSaves && negDeathSeaves == that.negDeathSeaves && availableHitDice == that.availableHitDice && Objects.equals(uuid, that.uuid) && Objects.equals(hitDice, that.hitDice) && Objects.equals(playerCharacter, that.playerCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, armorClass, hp, maxHp, tempHp, posDeathSaves, negDeathSeaves, hitDice, availableHitDice, playerCharacter);
    }
}
