package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.RpSheetRepository;
import com.nelis.compendium.core.domain.RpSheet;
import com.nelis.compendium.core.service.exception.RpSheetNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RpSheetService {
    private final Logger logger = LogManager.getLogger();
    private final RpSheetRepository rpSheetRepository;

    public RpSheet persistRpSheet(RpSheet rpSheet) {
        logger.info("Persisting RpSheet with id: " + rpSheet.getUuid());
        return rpSheetRepository.save(rpSheet);
    }

    public RpSheet getRpSheetById(UUID id) {
        logger.info("Retrieving RpSheet with id: " + id);
        return rpSheetRepository.findById(id).orElseThrow(() -> new RpSheetNotFound(id));
    }
}
