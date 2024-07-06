package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class ItemNotFound extends RuntimeException {
    public ItemNotFound(UUID id) {
        super("Item not found with message: " + id);
    }
}
