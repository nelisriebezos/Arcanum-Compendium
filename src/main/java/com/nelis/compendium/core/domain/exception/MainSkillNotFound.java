package com.nelis.compendium.core.domain.exception;

import com.nelis.compendium.core.domain.skills.SkillType;

public class MainSkillNotFound extends RuntimeException {
    public MainSkillNotFound(String type) {
        super("Mainskill of type: " + type + " was not found");
    }
}
