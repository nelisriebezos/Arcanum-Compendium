package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class RpSheetNotFound extends RuntimeException {
    public RpSheetNotFound(UUID id) {
        super("RpSheet with id " + id + " not found");
    }
}
