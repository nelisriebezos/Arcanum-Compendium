package com.arcanum.compendium.spellbook.service.exception;

import java.util.UUID;

public class AbilityNotFound extends RuntimeException {
    public AbilityNotFound(UUID uuid) {
        super("Ability not found with uuid: " + uuid);
    }
}
