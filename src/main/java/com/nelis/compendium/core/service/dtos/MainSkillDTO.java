package com.nelis.compendium.core.service.dtos;

import java.util.List;

public record MainSkillDTO(String name,
                           int baseValue,
                           int baseModifier,
                           List<SubSkillDTO> subSkills) {
}
