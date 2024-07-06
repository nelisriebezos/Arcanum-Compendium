package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class PlayerCharacterNotFound extends RuntimeException {
    public PlayerCharacterNotFound(UUID id) {
        super("PlayerCharacter with id: " + id + " not found");
    }
}
