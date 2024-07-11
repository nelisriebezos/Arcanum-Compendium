package com.nelis.compendium.javafx.dtos;

import java.util.List;

public record MainSkillDTO(String baseSkill, int baseValue, int baseModifier, List<SubSkillDTO> subSkills) {
}
