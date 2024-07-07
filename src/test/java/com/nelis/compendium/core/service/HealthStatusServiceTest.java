package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.HealthStatusRepository;
import com.nelis.compendium.core.domain.HealthStatus;
import com.nelis.compendium.core.service.exception.HealthStatusNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class HealthStatusServiceTest {
    @Autowired
    private HealthStatusService healthStatusService;
    @Autowired
    private HealthStatusRepository healthStatusRepository;

    private HealthStatus testHealthStatus;

    @BeforeEach
    void setUp() {
        healthStatusRepository.deleteAll();

        testHealthStatus = HealthStatus.builder()
                .build();
    }

    @Test
    void persistHealthStatus() {
        HealthStatus persistedHealthStatus = healthStatusService.persistHealthStatus(testHealthStatus);
        assertEquals(testHealthStatus, persistedHealthStatus);
    }

    @Test
    void getHealthStatusById() {
        HealthStatus persistedHealthStatus = healthStatusService.persistHealthStatus(testHealthStatus);
        HealthStatus retrievedHealthStatus = healthStatusService.getHealthStatusById(persistedHealthStatus.getUuid());
        assertEquals(persistedHealthStatus, retrievedHealthStatus);
    }

    @Test
    void getHealthStatusNotFound() {
        assertThrows(HealthStatusNotFound.class, () -> healthStatusService.getHealthStatusById(UUID.randomUUID()));
    }
}