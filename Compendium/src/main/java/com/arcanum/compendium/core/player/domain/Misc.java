package com.arcanum.compendium.core.player.domain;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "miscBuilder")
@Entity
public class Misc extends Item {
}
