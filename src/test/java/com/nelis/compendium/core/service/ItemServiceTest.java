package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.items.*;
import com.nelis.compendium.core.domain.items.enums.ArmorType;
import com.nelis.compendium.core.service.exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.nelis.compendium.core.domain.items.enums.WeaponProperty.LIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Autowired
    private ArmorRepository armorRepository;
    @Autowired
    private ConsumableRepository consumableRepository;
    @Autowired
    private MiscRepository miscRepository;
    @Autowired
    private ToolRepository toolRepository;
    @Autowired
    private WeaponRepository weaponRepository;


    private Consumable testConsumable;
    private Weapon testWeapon;
    private Armor testArmor;
    private Misc testMisc;
    private Tool testTool;

    @BeforeEach
    void setUp() {
        armorRepository.deleteAll();
        consumableRepository.deleteAll();
        miscRepository.deleteAll();
        toolRepository.deleteAll();
        weaponRepository.deleteAll();

        testConsumable = Consumable.consumableBuilder()
                .build();

        testWeapon = Weapon.weaponBuilder()
                .damage("1d6")
                .damageType("piercing")
                .isProficient(true)
                .properties(new ArrayList<>(List.of(LIGHT)))
                .build();

        testArmor = Armor.armorBuilder()
                .armorClass(10)
                .isProficient(true)
                .armorType(ArmorType.LEATHER)
                .minimumStrRequired(0)
                .stealthDisadvantage(false)
                .donTime(0)
                .doffTime(0)
                .build();

        testMisc = Misc.miscBuilder().build();

        testTool = Tool.toolBuilder()
                .isProficient(true)
                .build();
    }

    @Test
    void persistArmor() {
        Armor persistedArmor = itemService.persistArmor(testArmor);
        assertEquals(testArmor, persistedArmor);
    }

    @Test
    void getArmorById() {
        Armor persistedArmor = itemService.persistArmor(testArmor);
        Armor retrievedArmor = itemService.getArmorById(persistedArmor.getUuid());
        assertEquals(persistedArmor, retrievedArmor);
    }

    @Test
    void getArmorByIdNotFound() {
        assertThrows(ArmorNotFound.class, () -> itemService.getArmorById(UUID.randomUUID()));
    }

    @Test
    void deleteArmor() {
        Armor persistedArmor = itemService.persistArmor(testArmor);
        itemService.deleteArmor(persistedArmor.getUuid());
        assertEquals(0, armorRepository.count());
    }

    @Test
    void persistConsumable() {
        Consumable persistedConsumable = itemService.persistConsumable(testConsumable);
        assertEquals(testConsumable, persistedConsumable);
    }

    @Test
    void getConsumableById() {
        Consumable persistedConsumable = itemService.persistConsumable(testConsumable);
        Consumable retrievedConsumable = itemService.getConsumableById(persistedConsumable.getUuid());
        assertEquals(persistedConsumable, retrievedConsumable);
    }

    @Test
    void getConsumableByIdNotFound() {
        assertThrows(ConsumableNotFound.class, () -> itemService.getConsumableById(UUID.randomUUID()));
    }

    @Test
    void deleteConsumable() {
        Consumable persistedConsumable = itemService.persistConsumable(testConsumable);
        itemService.deleteConsumable(persistedConsumable.getUuid());
        assertEquals(0, consumableRepository.count());
    }

    @Test
    void persistMisc() {
        Misc persistedMisc = itemService.persistMisc(testMisc);
        assertEquals(testMisc, persistedMisc);
    }

    @Test
    void getMiscById() {
        Misc persistedMisc = itemService.persistMisc(testMisc);
        Misc retrievedMisc = itemService.getMiscById(persistedMisc.getUuid());
        assertEquals(persistedMisc, retrievedMisc);
    }

    @Test
    void getMiscByIdNotFound() {
        assertThrows(MiscNotFound.class, () -> itemService.getMiscById(UUID.randomUUID()));
    }

    @Test
    void deleteMisc() {
        Misc persistedMisc = itemService.persistMisc(testMisc);
        itemService.deleteMisc(persistedMisc.getUuid());
        assertEquals(0, miscRepository.count());
    }

    @Test
    void persistTool() {
        Tool persistedTool = itemService.persistTool(testTool);
        assertEquals(testTool, persistedTool);
    }

    @Test
    void getToolById() {
        Tool persistedTool = itemService.persistTool(testTool);
        Tool retrievedTool = itemService.getToolById(persistedTool.getUuid());
        assertEquals(persistedTool, retrievedTool);
    }

    @Test
    void getToolByIdNotFound() {
        assertThrows(ToolNotFound.class, () -> itemService.getToolById(UUID.randomUUID()));
    }

    @Test
    void deleteTool() {
        Tool persistedTool = itemService.persistTool(testTool);
        itemService.deleteTool(persistedTool.getUuid());
        assertEquals(0, toolRepository.count());
    }

    @Test
    void persistWeapon() {
        Weapon persistedWeapon = itemService.persistWeapon(testWeapon);
        assertEquals(testWeapon, persistedWeapon);
    }

    @Test
    void getWeaponById() {
        Weapon persistedWeapon = itemService.persistWeapon(testWeapon);
        Weapon retrievedWeapon = itemService.getWeaponById(persistedWeapon.getUuid());
        assertEquals(persistedWeapon, retrievedWeapon);
    }

    @Test
    void getWeaponByIdNotFound() {
        assertThrows(WeaponNotFound.class, () -> itemService.getWeaponById(UUID.randomUUID()));
    }

    @Test
    void deleteWeapon() {
        Weapon persistedWeapon = itemService.persistWeapon(testWeapon);
        itemService.deleteWeapon(persistedWeapon.getUuid());
        assertEquals(0, weaponRepository.count());
    }
}