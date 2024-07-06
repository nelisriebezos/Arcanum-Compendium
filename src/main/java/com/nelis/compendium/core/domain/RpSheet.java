package com.nelis.compendium.core.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    private ArrayList<String> personalityTraits = new ArrayList<>();
    private String ideals;
    private String bonds;
    private String flaws;
    private String eyeColour;
    private String backstory;
    private String hairColour;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private ArrayList<String> organizations = new ArrayList<>();
    private String skinColour;
    private int weight;
    private int height;
    private int age;
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private ArrayList<String> languages = new ArrayList<>();
    private Alignment alignment;
}
