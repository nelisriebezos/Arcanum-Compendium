package com.arcanum.compendium.core.domain.items;

import com.arcanum.compendium.core.domain.Inventory;
import com.arcanum.compendium.core.domain.PlayerCharacter;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return amount == item.amount && Objects.equals(uuid, item.uuid) && Objects.equals(name, item.name) && Objects.equals(description, item.description) && Objects.equals(inventory, item.inventory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, amount, description, inventory);
    }
}
