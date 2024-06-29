package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "weaponBuilder")
@Entity
public class Weapon extends Item {
    private String damage;
    private String damageType;
    private boolean isProficient;

    @ElementCollection
    private ArrayList<WeaponProperty> properties = new ArrayList<>();

}
