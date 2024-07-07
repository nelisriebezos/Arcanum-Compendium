//package com.nelis.compendium.core.service;
//
//import com.nelis.compendium.core.data.ItemRepository;
//import com.nelis.compendium.core.domain.items.*;
//import com.nelis.compendium.core.domain.items.enums.ArmorType;
//import com.nelis.compendium.core.service.ItemService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.nelis.compendium.core.domain.items.enums.WeaponProperty.LIGHT;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//@TestPropertySource(locations = "classpath:application-test.properties")
//class ItemServiceTest {
//    @Autowired
//    private ItemService itemService;
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    private Item testItem;
//    private Consumable testConsumable;
//    private Weapon testWeapon;
//    private Armor testArmor;
//    private Misc testMisc;
//    private Tool testTool;
//
//    @BeforeEach
//    void setUp() {
//        itemRepository.deleteAll();
//
//        testItem = Item.builder()
//                .name("Test Item")
//                .amount(10)
//                .description("A test item")
//                .build();
//
//        testConsumable = Consumable.consumableBuilder().build();
//
//        testWeapon = Weapon.weaponBuilder()
//                .damage("1d6")
//                .damageType("piercing")
//                .isProficient(true)
//                .properties(new ArrayList<>(List.of(LIGHT)))
//                .build();
//
//        testArmor = Armor.armorBuilder()
//                .armorClass(10)
//                .isProficient(true)
//                .armorType(ArmorType.LEATHER)
//                .minimumStrRequired(0)
//                .stealthDisadvantage(false)
//                .donTime(0)
//                .doffTime(0)
//                .build();
//
//        testMisc = Misc.miscBuilder().build();
//
//        testTool = Tool.toolBuilder()
//                .isProficient(true)
//                .build();
//    }
//
//    @Test
//    void persistItem() {
//        itemService.persistItem(testItem);
//        itemService.persistItem(testConsumable);
//        itemService.persistItem(testWeapon);
//        itemService.persistItem(testArmor);
//        itemService.persistItem(testMisc);
//        itemService.persistItem(testTool);
//
//        assert itemRepository.findAll().size() == 6;
//    }
//
//    @Test
//    void getItemById() {
//        testItem = itemService.persistItem(testItem);
//        testConsumable = itemService.persistItem(testConsumable);
//        testWeapon = itemService.persistItem(testWeapon);
//        testArmor = itemService.persistItem(testArmor);
//        testMisc = itemService.persistItem(testMisc);
//        testTool = itemService.persistItem(testTool);
//
//
//        assertEquals(itemService.getItemById(testItem.getUuid()).getClass(), testItem.getClass());
//        assertEquals(itemService.getItemById(testItem.getUuid()), testItem);
//        assertEquals(itemService.getItemById(testConsumable.getUuid()).getClass(), testConsumable.getClass());
//        assertEquals(itemService.getItemById(testConsumable.getUuid()), testConsumable);
//        assertEquals(itemService.getItemById(testArmor.getUuid()).getClass(), testArmor.getClass());
//        assertEquals(itemService.getItemById(testArmor.getUuid()), testArmor);
//        assertEquals(itemService.getItemById(testMisc.getUuid()).getClass(), testMisc.getClass());
//        assertEquals(itemService.getItemById(testMisc.getUuid()), testMisc);
//        assertEquals(itemService.getItemById(testTool.getUuid()).getClass(), testTool.getClass());
//        assertEquals(itemService.getItemById(testTool.getUuid()), testTool);
//        assertEquals(itemService.getItemById(testWeapon.getUuid()).getClass(), testWeapon.getClass());
//        assertEquals(itemService.getItemById(testWeapon.getUuid()), testWeapon);
//    }
//
//    @Test
//    void deleteItem() {
//        itemService.persistItem(testItem);
//        itemService.persistItem(testConsumable);
//        itemService.persistItem(testWeapon);
//        itemService.persistItem(testArmor);
//        itemService.persistItem(testMisc);
//        itemService.persistItem(testTool);
//
//        assert itemRepository.findAll().size() == 6;
//
//        itemService.deleteItem(testItem.getUuid());
//        itemService.deleteItem(testConsumable.getUuid());
//        itemService.deleteItem(testWeapon.getUuid());
//        itemService.deleteItem(testArmor.getUuid());
//        itemService.deleteItem(testMisc.getUuid());
//        itemService.deleteItem(testTool.getUuid());
//
//        assert itemRepository.findAll().isEmpty();
//    }
//}