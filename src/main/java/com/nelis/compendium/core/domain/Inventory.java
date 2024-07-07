package com.nelis.compendium.core.domain;

import com.nelis.compendium.core.domain.items.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Weapon> weapons = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Armor> armor = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Consumable> consumables = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Misc> Miscellaneous = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @Builder.Default
    private List<Tool> tools = new ArrayList<>();

//    @OneToOne
//    @JoinColumn(name = "player_character_id")
//    private PlayerCharacter playerCharacter;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Inventory inventory = (Inventory) o;
        return getUuid() != null && Objects.equals(getUuid(), inventory.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
