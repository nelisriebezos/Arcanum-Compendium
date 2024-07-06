package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class SpellBookNotFound extends RuntimeException {
    public SpellBookNotFound(UUID uuid) {
        super("SpellBook not found with uuid: " + uuid);
    }
}
