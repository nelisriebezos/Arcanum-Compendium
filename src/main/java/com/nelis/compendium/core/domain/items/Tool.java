package com.nelis.compendium.core.domain.items;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "toolBuilder")
@Entity
public class Tool extends Item {
    private boolean isProficient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tool tool = (Tool) o;
        return isProficient == tool.isProficient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isProficient);
    }
}
