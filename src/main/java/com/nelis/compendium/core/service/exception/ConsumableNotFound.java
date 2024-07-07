package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class ConsumableNotFound extends RuntimeException {
    public ConsumableNotFound(UUID id) {
        super("Consumable with id: " + id + " not found");
    }
}
