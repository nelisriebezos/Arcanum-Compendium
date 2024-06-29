package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "toolBuilder")
@Entity
public class Tool extends Item {
    private boolean isProficient;
    private String description;


}
