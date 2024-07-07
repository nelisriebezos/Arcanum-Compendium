package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class HealthStatusNotFound extends RuntimeException {
    public HealthStatusNotFound(UUID id) {
        super("HealthStatus with id: " + id + " not found");
    }
}
