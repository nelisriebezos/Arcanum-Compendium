package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.RpSheetRepository;
import com.nelis.compendium.core.domain.RpSheet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class RpSheetServiceTest {
    @Autowired
    private RpSheetService rpSheetService;
    @Autowired
    private RpSheetRepository rpSheetRepository;

    private RpSheet testRpSheet;

    @BeforeEach
    void setUp() {
        rpSheetRepository.deleteAll();

        testRpSheet = RpSheet.builder()
                .build();
    }

    @Test
    void persistRpSheet() {
        RpSheet persistedRpSheet = rpSheetService.persistRpSheet(testRpSheet);
        assertEquals(testRpSheet, persistedRpSheet);
    }

    @Test
    void getRpSheetById() {
        RpSheet persistedRpSheet = rpSheetService.persistRpSheet(testRpSheet);
        RpSheet retrievedRpSheet = rpSheetService.getRpSheetById(persistedRpSheet.getUuid());
        assertEquals(persistedRpSheet, retrievedRpSheet);
    }
}