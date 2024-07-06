package com.nelis.compendium.core.domain;

import jakarta.persistence.*;
import lombok.*;

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
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> personalityTraits = new ArrayList<>();
    private String ideals;
    private String bonds;
    private String flaws;
    private String eyeColour;
    private String backstory;
    private String hairColour;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> organizations = new ArrayList<>();
    private String skinColour;
    private int weight;
    private int height;
    private int age;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> languages = new ArrayList<>();
    private Alignment alignment;
    @OneToOne
    private PlayerCharacter playerCharacter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpSheet rpSheet)) return false;
        return weight == rpSheet.weight && height == rpSheet.height && age == rpSheet.age && Objects.equals(uuid, rpSheet.uuid) && Objects.equals(race, rpSheet.race) && Objects.equals(personalityTraits, rpSheet.personalityTraits) && Objects.equals(ideals, rpSheet.ideals) && Objects.equals(bonds, rpSheet.bonds) && Objects.equals(flaws, rpSheet.flaws) && Objects.equals(eyeColour, rpSheet.eyeColour) && Objects.equals(backstory, rpSheet.backstory) && Objects.equals(hairColour, rpSheet.hairColour) && Objects.equals(organizations, rpSheet.organizations) && Objects.equals(skinColour, rpSheet.skinColour) && Objects.equals(languages, rpSheet.languages) && alignment == rpSheet.alignment && Objects.equals(playerCharacter, rpSheet.playerCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, race, personalityTraits, ideals, bonds, flaws, eyeColour, backstory, hairColour, organizations, skinColour, weight, height, age, languages, alignment, playerCharacter);
    }
}
