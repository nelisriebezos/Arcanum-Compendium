package com.nelis.compendium.core.service;

import com.nelis.compendium.core.data.PlayerCharacterRepository;
import com.nelis.compendium.core.data.RpSheetRepository;
import com.nelis.compendium.core.data.SpellRepository;
import com.nelis.compendium.core.domain.PlayerCharacter;
import com.nelis.compendium.core.domain.RpSheet;
import com.nelis.compendium.core.domain.skills.SkillName;
import com.nelis.compendium.core.service.exception.PlayerCharacterNotFound;
import com.nelis.compendium.core.service.exception.RpSheetNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerCharacterService {
    private static final Logger logger = LogManager.getLogger();
    private final PlayerCharacterRepository playerCharacterRepository;

    public PlayerCharacter persistPlayerCharacter(PlayerCharacter playerCharacter) {
        logger.info("Persisting playerCharacter with id: " + playerCharacter.getUuid());
        return playerCharacterRepository.save(playerCharacter);
    }

    public PlayerCharacter getPlayerCharacterById(UUID id) {
        logger.info("Retrieving PlayerCharacter with id: " + id);
        return playerCharacterRepository.findById(id).orElseThrow(() -> new PlayerCharacterNotFound(id));
    }

    public void deletePlayerCharacter(UUID id) {
        logger.info("Deleting PlayerCharacter with id: " + id);
        playerCharacterRepository.deleteById(id);
    }

//    todo: event om de front-end te updaten?
    public void triggerProficiency(PlayerCharacter character, SkillName skillName) {
        character.getSkillByName(skillName).triggerProficiency();
    }
}
