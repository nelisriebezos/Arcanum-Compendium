package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.Inventory;
import com.nelis.compendium.core.domain.PlayerCharacter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private int amount;
    private String description;
}
