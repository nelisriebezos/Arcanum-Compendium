package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.Ability;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "consumableBuilder")
@Entity
public class Consumable extends Item implements Ability {
    private String consumableType;
    private String effect;
    private List<String> tags ;

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Consumable that = (Consumable) o;
        return Objects.equals(consumableType, that.consumableType) && Objects.equals(effect, that.effect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), consumableType, effect, tags);
    }
}
