package com.arcanum.compendium.spellbook.service.converter;

import com.arcanum.compendium.spellbook.domain.Component;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter
public class ComponentConverter implements AttributeConverter<Set<Component>, String> {
    @Override
    public String convertToDatabaseColumn(Set<Component> components) {
        if (components == null || components.isEmpty()) {
            return "";
        }
        return components.stream().map(Component::name).collect(Collectors.joining(","));
    }

    @Override
    public Set<Component> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return new HashSet<>();
        }
        return Stream.of(dbData.split(","))
                .map(Component::valueOf)
                .collect(Collectors.toSet());
    }
}
