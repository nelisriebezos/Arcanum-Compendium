package com.nelis.compendium.environment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record SpellDTO(@JsonProperty("Name") String name,
                       @JsonProperty("CastingTime") String castingTime,
                       @JsonProperty("Range") String range,
                       @JsonProperty("Components") Set<String> components,
                       @JsonProperty("Duration") String duration,
                       @JsonProperty("Description") String description) {
}
