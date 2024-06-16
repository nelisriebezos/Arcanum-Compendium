package com.arcanum.compendium.spellbook.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Set;

public record SpellDTO(@JsonProperty("Name") String name,
                       @JsonProperty("CastingTime") String castingTime,
                       @JsonProperty("Range") String range,
                       @JsonProperty("Components") Set<String> components,
                       @JsonProperty("Duration") String duration,
                       @JsonProperty("Description") String description) {
}
