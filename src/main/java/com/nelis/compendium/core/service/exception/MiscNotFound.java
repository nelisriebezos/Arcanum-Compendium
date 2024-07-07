package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class MiscNotFound extends RuntimeException {
    public MiscNotFound(UUID id) {
        super("Misc with id " + id + " not found");
    }
}
