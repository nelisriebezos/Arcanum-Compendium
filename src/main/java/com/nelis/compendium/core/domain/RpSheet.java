package com.nelis.compendium.core.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RpSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String race;
    @ElementCollection
    @Builder.Default
    private List<String> personalityTraits = new ArrayList<>();
    private String ideals;
    private String bonds;
    private String flaws;
    private String eyeColour;
    private String backstory;
    private String hairColour;
    @ElementCollection
    @Builder.Default
    private List<String> organizations = new ArrayList<>();
    private String skinColour;
    private int weight;
    private int height;
    private int age;
    @ElementCollection
    @Builder.Default
    private List<String> languages = new ArrayList<>();
    private Alignment alignment;
    @OneToOne
    private PlayerCharacter playerCharacter;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        RpSheet student = (RpSheet) o;
        return getUuid() != null && Objects.equals(getUuid(), student.getUuid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();     }
}
