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
public class MainStat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private SkillType name;
    private int value;
    private int modifier;
    @ManyToOne
    private PlayerCharacter playerCharacter;
}
