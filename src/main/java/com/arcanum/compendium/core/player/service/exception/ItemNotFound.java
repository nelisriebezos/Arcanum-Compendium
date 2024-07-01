package com.arcanum.compendium.core.player.service.exception;

import java.util.UUID;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound(UUID id) {
        super("Item not found with message: " + id);
    }
}
