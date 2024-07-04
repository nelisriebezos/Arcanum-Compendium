package com.arcanum.compendium.core.domain.items;

import com.arcanum.compendium.core.domain.items.enums.ArmorType;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

//    public int calculateAC() {
//        return switch (armorType) {
//            case PADDED, STUDDED_LEATHER, LEATHER -> armorClass + getPlayerCharacter().getDexModifier();
//            case HIDE, CHAIN_SHIRT, SCALE_MAIL, BREASTPLATE, HALF_PLATE ->
//                    armorClass + Math.min(2, getPlayerCharacter().getDexModifier());
//            case RING_MAIL, CHAIN_MAIL, SPLINT, PLATE -> armorClass;
//            default -> armorClass;
//        };
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Armor armor = (Armor) o;
        return armorClass == armor.armorClass && isProficient == armor.isProficient && minimumStrRequired == armor.minimumStrRequired && stealthDisadvantage == armor.stealthDisadvantage && donTime == armor.donTime && doffTime == armor.doffTime && armorType == armor.armorType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), armorClass, isProficient, armorType, minimumStrRequired, stealthDisadvantage, donTime, doffTime);
    }
}
