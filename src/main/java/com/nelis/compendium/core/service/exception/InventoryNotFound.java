package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class InventoryNotFound extends RuntimeException {
    public InventoryNotFound(UUID id) {
        super("Inventory with id: " + id + " not found");
    }
}
