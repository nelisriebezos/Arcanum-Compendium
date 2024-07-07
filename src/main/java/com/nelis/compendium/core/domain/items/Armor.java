package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.items.enums.ArmorType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
    @Enumerated(EnumType.STRING)
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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Armor armor = (Armor) o;
        return getUuid() != null && Objects.equals(getUuid(), armor.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
