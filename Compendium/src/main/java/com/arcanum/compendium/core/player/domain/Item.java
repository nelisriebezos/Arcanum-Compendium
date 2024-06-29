package com.arcanum.compendium.core.player.domain;

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
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private int amount;
    private String description;
    @ManyToOne
    private Inventory inventory;

    public PlayerCharacter getPlayerCharacter() {
        return inventory.getPlayerCharacter();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid());
    }
}
