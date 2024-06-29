package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "armorBuilder")
@Entity
public class Armor extends Item {
    private int armorClass;
    private boolean isProficient;
    private ArmorType armorType;
    private int minimumStrRequired;
    private boolean stealthDisadvantage;
    private int donTime;
    private int doffTime;

    public int calculateAC() {
        switch (armorType) {
            case PADDED, STUDDED_LEATHER, LEATHER:
                return armorClass + getPlayerCharacter().getDexModifier();
            case HIDE, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE:
                return armorClass + Math.min(2, getPlayerCharacter().getDexModifier());
                case RING_MAIL, CHAIN_MAIL, SPLINT, PLATE:
                    return armorClass;

            default:
                return armorClass;
        }
    }
}
