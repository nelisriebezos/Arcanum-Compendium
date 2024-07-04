package com.arcanum.compendium.core.service.exception;

import java.util.UUID;

public class SpellNotFound extends RuntimeException {
    public SpellNotFound(UUID id) {
        super("Spell not found with message: " + id);
    }
}
