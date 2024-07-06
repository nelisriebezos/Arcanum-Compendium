package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.Ability;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "miscBuilder")
@Entity
public class Misc extends Item implements Ability {
    private String miscType;

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
        Misc misc = (Misc) o;
        return Objects.equals(miscType, misc.miscType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), miscType);
    }
}
