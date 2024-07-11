package com.nelis.compendium.javafx.dtos;

import java.util.List;

public record MainSkillDTO(String name, int baseValue, int baseModifier, List<SubSkillDTO> subSkills) {
}
