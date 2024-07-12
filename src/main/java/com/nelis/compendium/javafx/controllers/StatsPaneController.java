package com.nelis.compendium.javafx.controllers;

import com.nelis.compendium.core.domain.PlayerCharacter;
import com.nelis.compendium.core.service.PlayerCharacterService;
import com.nelis.compendium.javafx.FxmlStateService;
import com.nelis.compendium.javafx.SubComponentService;
import com.nelis.compendium.core.service.dtos.MainSkillDTO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatsPaneController {
    private final PlayerCharacterService playerCharacterService;
    private final SubComponentService subComponentService;
    private final FxmlStateService fxmlStateService;

    @FXML
    private VBox skillsList;

    public StatsPaneController(PlayerCharacterService playerCharacterService, SubComponentService subComponentService, FxmlStateService fxmlStateService) {
        this.playerCharacterService = playerCharacterService;
        this.subComponentService = subComponentService;
        this.fxmlStateService = fxmlStateService;
    }

    @FXML
    private void initialize() {
//        TODO: get character from state, and manage it via state
        PlayerCharacter character = playerCharacterService.createCharacter();

        List<MainSkillDTO> mainSkillDTOS = playerCharacterService.getMainSkills(character);
        updateSkillBox(mainSkillDTOS);
    }

    private void updateSkillBox(List<MainSkillDTO> mainSkillData) {
        for (MainSkillDTO dto : mainSkillData) {
            SplitPane table = subComponentService.createSkillTable(dto);
            skillsList.getChildren().add(table);
        }
    }
}
