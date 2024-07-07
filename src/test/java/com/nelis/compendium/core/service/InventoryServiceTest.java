package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.Inventory;
import com.nelis.compendium.core.domain.items.*;
import com.nelis.compendium.core.domain.items.enums.ArmorType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static com.nelis.compendium.core.domain.items.enums.WeaponProperty.LIGHT;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class InventoryServiceTest {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private InventoryRepository inventoryRepository;

    private Inventory testInventory;

    @BeforeEach
    void setUp() {
        inventoryRepository.deleteAll();

        Consumable testConsumable = Consumable.consumableBuilder()
                .build();

        Weapon testWeapon = Weapon.weaponBuilder()
                .damage("1d6")
                .damageType("piercing")
                .isProficient(true)
                .properties(new ArrayList<>(List.of(LIGHT)))
                .build();

        Armor testArmor = Armor.armorBuilder()
                .armorClass(10)
                .isProficient(true)
                .armorType(ArmorType.LEATHER)
                .minimumStrRequired(0)
                .stealthDisadvantage(false)
                .donTime(0)
                .doffTime(0)
                .build();

        Misc testMisc = Misc.miscBuilder().build();

        Tool testTool = Tool.toolBuilder()
                .isProficient(true)
                .build();

        testInventory = Inventory.builder()
                .consumables(new ArrayList<>(List.of(testConsumable)))
                .weapons(new ArrayList<>(List.of(testWeapon)))
                .armor(new ArrayList<>(List.of(testArmor)))
                .Miscellaneous(new ArrayList<>(List.of(testMisc)))
                .tools(new ArrayList<>(List.of(testTool)))
                .build();
    }

    @Test
    void persistInventory() {
        Inventory inventory = inventoryService.persistInventory(testInventory);
        assertNotNull(inventory);
        assertNotNull(inventory.getUuid());
        assertEquals(testInventory, inventory);
        assertEquals(testInventory.getConsumables().size(), inventory.getConsumables().size());
        assertEquals(testInventory.getWeapons().size(), inventory.getWeapons().size());
        assertEquals(testInventory.getArmor().size(), inventory.getArmor().size());
        assertEquals(testInventory.getMiscellaneous().size(), inventory.getMiscellaneous().size());
        assertEquals(testInventory.getTools().size(), inventory.getTools().size());
    }

    @Test
    void getInventoryById() {
        Inventory inventory = inventoryService.persistInventory(testInventory);
        Inventory retrievedInventory = inventoryService.getInventoryById(inventory.getUuid());
        assertEquals(inventory, retrievedInventory);
    }
}