package com.arcanum.compendium.core.domain.skills;

import com.arcanum.compendium.core.domain.PlayerCharacter;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private int modifier;
    private SkillType skillType;
    private boolean isSavingThrow;
    private boolean isProficient;
    @ManyToOne
    private PlayerCharacter playerCharacter;
}
