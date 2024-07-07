package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.*;
import com.nelis.compendium.core.domain.items.*;
import com.nelis.compendium.core.service.exception.*;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ItemService {
    private static final Logger logger = LogManager.getLogger();
    private final ArmorRepository armorRepository;
    private final ConsumableRepository consumableRepository;
    private final MiscRepository miscRepository;
    private final ToolRepository toolRepository;
    private final WeaponRepository weaponRepository;

    public Armor persistArmor(Armor armor) {
        logger.info("Persisting Armor with id: " + armor.getUuid());
        return armorRepository.save(armor);
    }

    public Armor getArmorById(UUID id) {
        logger.info("Retrieving Armor with id: " + id);
        return armorRepository.findById(id).orElseThrow(() -> new ArmorNotFound(id));
    }

    public void deleteArmor(UUID id) {
        logger.info("Deleting Armor with id: " + id);
        armorRepository.deleteById(id);
    }

    public Consumable persistConsumable(Consumable consumable) {
        logger.info("Persisting Consumable with id: " + consumable.getUuid());
        return consumableRepository.save(consumable);
    }

    public Consumable getConsumableById(UUID id) {
        logger.info("Retrieving Consumable with id: " + id);
        return consumableRepository.findById(id).orElseThrow(() -> new ConsumableNotFound(id));
    }

    public void deleteConsumable(UUID id) {
        logger.info("Deleting Consumable with id: " + id);
        consumableRepository.deleteById(id);
    }

    public Misc persistMisc(Misc misc) {
        logger.info("Persisting Misc with id: " + misc.getUuid());
        return miscRepository.save(misc);
    }

    public Misc getMiscById(UUID id) {
        logger.info("Retrieving Misc with id: " + id);
        return miscRepository.findById(id).orElseThrow(() -> new MiscNotFound(id));
    }

    public void deleteMisc(UUID id) {
        logger.info("Deleting Misc with id: " + id);
        miscRepository.deleteById(id);
    }

    public Tool persistTool(Tool tool) {
        logger.info("Persisting Tool with id: " + tool.getUuid());
        return toolRepository.save(tool);
    }

    public Tool getToolById(UUID id) {
        logger.info("Retrieving Tool with id: " + id);
        return toolRepository.findById(id).orElseThrow(() -> new ToolNotFound(id));
    }

    public void deleteTool(UUID id) {
        logger.info("Deleting Tool with id: " + id);
        toolRepository.deleteById(id);
    }

    public Weapon persistWeapon(Weapon weapon) {
        logger.info("Persisting Weapon with id: " + weapon.getUuid());
        return weaponRepository.save(weapon);
    }

    public Weapon getWeaponById(UUID id) {
        logger.info("Retrieving Weapon with id: " + id);
        return weaponRepository.findById(id).orElseThrow(() -> new WeaponNotFound(id));
    }

    public void deleteWeapon(UUID id) {
        logger.info("Deleting Weapon with id: " + id);
        weaponRepository.deleteById(id);
    }

}
