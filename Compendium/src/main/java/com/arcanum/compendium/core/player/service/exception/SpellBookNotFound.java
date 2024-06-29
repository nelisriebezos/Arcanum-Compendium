package com.arcanum.compendium.core.player.service.exception;

import java.util.UUID;

public class SpellBookNotFound extends RuntimeException {
    public SpellBookNotFound(UUID uuid) {
        super("SpellBook not found with uuid: " + uuid);
    }
}
