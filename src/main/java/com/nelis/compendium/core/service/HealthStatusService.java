package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.HealthStatusRepository;
import com.nelis.compendium.core.domain.HealthStatus;
import com.nelis.compendium.core.service.exception.HealthStatusNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class HealthStatusService {
    private final Logger logger = LogManager.getLogger();
    private final HealthStatusRepository healthStatusRepository;

    public HealthStatus persistHealthStatus(HealthStatus healthStatus) {
        logger.info("Persisting HealthStatus with id: " + healthStatus.getUuid());
        return healthStatusRepository.save(healthStatus);
    }

    public HealthStatus getHealthStatusById(UUID id) {
        logger.info("Retrieving HealthStatus with id: " + id);
        return healthStatusRepository.findById(id).orElseThrow(() -> new HealthStatusNotFound(id));
    }
}
