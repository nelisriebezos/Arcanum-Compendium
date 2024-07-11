package com.nelis.compendium.core.domain.exception;

public class SkillNotFound extends RuntimeException {
    public SkillNotFound(String type) {
        super("Skill of type: " + type + " was not found");
    }
}
