package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class WeaponNotFound extends RuntimeException {
    public WeaponNotFound(UUID id) {
        super("Weapon with id: " + id + " not found");
    }
}
