package com.nelis.compendium.core.data;

import com.nelis.compendium.core.domain.HealthStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HealthStatusRepository extends JpaRepository<HealthStatus, UUID> {
}
