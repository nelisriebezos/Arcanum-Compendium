package com.nelis.compendium.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @OneToOne
    private PlayerCharacter playerCharacter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventory inventory)) return false;
        return Objects.equals(uuid, inventory.uuid) && Objects.equals(playerCharacter, inventory.playerCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, playerCharacter);
    }

}
