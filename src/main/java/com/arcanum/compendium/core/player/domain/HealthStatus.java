package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
}
