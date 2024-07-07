package com.nelis.compendium.core.domain.items;

import com.nelis.compendium.core.domain.Ability;
import com.nelis.compendium.core.domain.PlayerCharacter;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

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
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Misc misc = (Misc) o;
        return getUuid() != null && Objects.equals(getUuid(), misc.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
