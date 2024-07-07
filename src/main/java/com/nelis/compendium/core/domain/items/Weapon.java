package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.PlayerCharacter;
import com.nelis.compendium.core.domain.items.enums.WeaponProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private List<WeaponProperty> properties = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Weapon weapon = (Weapon) o;
        return getUuid() != null && Objects.equals(getUuid(), weapon.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
