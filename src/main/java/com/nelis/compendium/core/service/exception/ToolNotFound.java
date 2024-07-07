package com.nelis.compendium.core.service.exception;

import java.util.UUID;

public class ToolNotFound extends RuntimeException {
    public ToolNotFound(UUID id) {
        super("Tool with id " + id + " not found");
    }
}
