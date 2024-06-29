package com.arcanum.compendium.core.player.service.exception;

import java.util.UUID;

public class SpellNotFound extends RuntimeException {
    public SpellNotFound(String message) {
        super(message);
    }
}
