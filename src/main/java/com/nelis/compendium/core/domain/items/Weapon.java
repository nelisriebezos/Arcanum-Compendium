package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.items.enums.WeaponProperty;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "weaponBuilder")
@Entity
public class Weapon extends Item {
    private String damage;
    private String damageType;
    private boolean isProficient;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<WeaponProperty> properties = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Weapon weapon = (Weapon) o;
        return isProficient == weapon.isProficient &&
                Objects.equals(damage, weapon.damage) &&
                Objects.equals(damageType, weapon.damageType) &&
                Objects.equals(new ArrayList<>(properties), new ArrayList<>(weapon.properties));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), damage, damageType, isProficient, properties);
    }
}
