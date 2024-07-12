package com.nelis.compendium.core.service;

import com.nelis.compendium.Main;
import com.nelis.compendium.core.data.PlayerCharacterRepository;
import com.nelis.compendium.core.data.RpSheetRepository;
import com.nelis.compendium.core.data.SpellRepository;
import com.nelis.compendium.core.domain.PlayerCharacter;
import com.nelis.compendium.core.domain.RpSheet;
import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.Skill;
import com.nelis.compendium.core.domain.skills.SkillName;
import com.nelis.compendium.core.service.dtos.MainSkillDTO;
import com.nelis.compendium.core.service.dtos.SubSkillDTO;
import com.nelis.compendium.core.service.exception.PlayerCharacterNotFound;
import com.nelis.compendium.core.service.exception.RpSheetNotFound;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static com.nelis.compendium.core.domain.skills.SkillName.*;
import static com.nelis.compendium.core.domain.skills.SkillName.SURVIVAL;
import static com.nelis.compendium.core.domain.skills.SkillType.*;

@Service
@AllArgsConstructor
public class PlayerCharacterService {
    private static final Logger logger = LogManager.getLogger();
    private final PlayerCharacterRepository playerCharacterRepository;
    private final Main main;

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

    public List<MainSkillDTO> getMainSkills(PlayerCharacter character) {
        List<MainSkillDTO> mainSkills = new ArrayList<>();
        for (MainSkill mainskill : character.getMainSkills()) {
            List<SubSkillDTO> subSkills = new ArrayList<>();
            character.getSkillsByType(mainskill.getName()).forEach(skill -> {
                SubSkillDTO subSkillDTO = new SubSkillDTO(skill.getName().getValue(), skill.getModifier(), skill.isProficient());
                subSkills.add(subSkillDTO);
            });
            MainSkillDTO mainSkillDTO = new MainSkillDTO(mainskill.getName().getValue(), mainskill.getValue(), mainskill.getModifier(), subSkills);
            mainSkills.add(mainSkillDTO);
        }
        return mainSkills;
    }

    public PlayerCharacter createCharacter() {
        PlayerCharacter character = new PlayerCharacter("Fighter", 30, 1, 2, 0);

        MainSkill strength = new MainSkill(STRENGTH, 18, character);
        MainSkill dexterity = new MainSkill(DEXTERITY, 16, character);
        MainSkill constitution = new MainSkill(CONSTITUTION, 16, character);
        MainSkill intelligence = new MainSkill(INTELLIGENCE, 8, character);
        MainSkill wisdom = new MainSkill(WISDOM, 10, character);
        MainSkill charisma = new MainSkill(CHARISMA, 13, character);
        Set<MainSkill> mainSkills = Set.of(strength, dexterity, constitution, intelligence, wisdom, charisma);
        mainSkills.forEach(MainSkill::calculateSkillModifier);
        character.setMainSkills(mainSkills);

        Skill strengthSave = new Skill(STRENGTH_ST, STRENGTH, true, character);
        Skill dexteritySave = new Skill(DEXTERITY_ST, DEXTERITY, true, character);
        Skill constitutionSave = new Skill(CONSTITUTION_ST, CONSTITUTION, false, character);
        Skill intelligenceSave = new Skill(INTELLIGENCE_ST, INTELLIGENCE, true, character);
        Skill wisdomSave = new Skill(WISDOM_ST, WISDOM, false, character);
        Skill charismaSave = new Skill(CHARISMA_ST, CHARISMA, false, character);
        Skill acrobatics = new Skill(ACROBATICS, DEXTERITY, true, character);
        Skill animalHandling = new Skill(ANIMAL_HANDLING, WISDOM, true, character);
        Skill arcana = new Skill(ARCANA, INTELLIGENCE, true, character);
        Skill athletics = new Skill(ATHLETICS, STRENGTH, false, character);
        Skill deception = new Skill(DECEPTION, CHARISMA, true, character);
        Skill history = new Skill(HISTORY, INTELLIGENCE, false, character);
        Skill insight = new Skill(INSIGHT, WISDOM, true, character);
        Skill intimidation = new Skill(INTIMIDATION, CHARISMA, false, character);
        Skill investigation = new Skill(INVESTIGATION, INTELLIGENCE, false, character);
        Skill medicine = new Skill(MEDICINE, WISDOM, false, character);
        Skill nature = new Skill(NATURE, INTELLIGENCE, false, character);
        Skill perception = new Skill(PERCEPTION, WISDOM, true, character);
        Skill performance = new Skill(PERFORMANCE, CHARISMA, false, character);
        Skill persuasion = new Skill(PERSUASION, CHARISMA, false, character);
        Skill religion = new Skill(RELIGION, INTELLIGENCE, true, character);
        Skill sleightOfHand = new Skill(SLEIGHT_OF_HAND, DEXTERITY, false, character);
        Skill stealth = new Skill(STEALTH, DEXTERITY, true, character);
        Skill survival = new Skill(SURVIVAL, WISDOM, false, character);
        Set<Skill> skills = Set.of(
                strengthSave, dexteritySave, constitutionSave, intelligenceSave, wisdomSave, charismaSave,
                acrobatics, animalHandling, arcana, athletics, deception, history, insight, intimidation,
                investigation, medicine, nature, perception, performance, persuasion, religion, sleightOfHand,
                stealth, survival
        );
        character.setSkills(skills);

        return character;
    }
}
