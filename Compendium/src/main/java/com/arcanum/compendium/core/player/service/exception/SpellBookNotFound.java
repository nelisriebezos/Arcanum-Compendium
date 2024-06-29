package com.arcanum.compendium.core.player.service.exception;

import java.util.UUID;

public class SpellBookNotFound extends RuntimeException {
    public SpellBookNotFound(String message) {
        super(message);
    }
}
