package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class ArmorNotFound extends RuntimeException {
    public ArmorNotFound(UUID id) {
        super("Armor with id: " + id + " not found");
    }
}
