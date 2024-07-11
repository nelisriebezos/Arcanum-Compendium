package com.nelis.compendium.javafx.controllers;

import com.nelis.compendium.core.domain.skills.Skill;
import com.nelis.compendium.core.service.PlayerCharacterService;
import com.nelis.compendium.javafx.dtos.MainSkillDTO;
import com.nelis.compendium.javafx.dtos.SubSkillDTO;
import com.nelis.compendium.utils.JsonUtils;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class StatsPaneController {
    private final PlayerCharacterService playerCharacterService;

    @FXML
    private VBox skillBox;

    @FXML
    private Label baseSkillLabel;

    @FXML
    private VBox baseSkillRow;

    @FXML
    private VBox skillsList;

    public StatsPaneController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @FXML
    private void initialize() {
        SubSkillDTO skill = new SubSkillDTO("Acrobatics", 2, false);
        SubSkillDTO skill2 = new SubSkillDTO("Animal Handling", 3, true);
        SubSkillDTO skill3 = new SubSkillDTO("Arcana", 2, false);
        SubSkillDTO skill4 = new SubSkillDTO("Athletics", 1, true);
        MainSkillDTO ms1 = new MainSkillDTO("Strength", 10, 0, List.of(skill, skill2));
        MainSkillDTO ms2 = new MainSkillDTO("dex", 10, 0, List.of(skill3, skill4));
        updateSkillBox(List.of(ms1, ms2));

    }

    private void updateSkillBox(List<MainSkillDTO> mainSkillData) {
        for (MainSkillDTO mainSkill : mainSkillData) {
            String plusMinus = " ";
            if (mainSkill.baseModifier() == 0) {
                plusMinus = " 0 ";
            } else if (mainSkill.baseModifier() > 0) {
                plusMinus = " +" + mainSkill.baseModifier();
            } else {
                plusMinus = " -" + mainSkill.baseModifier();
            }

            VBox baseSkillRow = new VBox();
            Label baseSkillLabel = new Label();

            baseSkillLabel.setText(mainSkill.baseSkill() + ": " + mainSkill.baseValue() + plusMinus + mainSkill.baseModifier());

            baseSkillLabel.setStyle("-fx-font-weight: bold;");
            baseSkillRow.setStyle("-fx-border-width: 0 0 2px 0; " +
                    "-fx-border-color: black;" +
                    "-fx-background-color: lightblue");

            skillsList.getChildren().add(baseSkillLabel);
            skillsList.getChildren().add(baseSkillRow);


            // Add skills to the skills list
            for (SubSkillDTO subSkill : mainSkill.subSkills()) {
                String plusMinusForSkill = " ";
                if (subSkill.modifier() == 0) {
                    plusMinusForSkill = " 0 ";
                } else if (subSkill.modifier() > 0) {
                    plusMinusForSkill = " +" + subSkill.modifier();
                } else {
                    plusMinusForSkill = " -" + subSkill.modifier();
                }

                HBox skillRow = new HBox();
                Label skillLabel = new Label(subSkill.name() + plusMinusForSkill + subSkill.modifier());
                CheckBox proficiencyButton = new CheckBox();
                if (subSkill.isProficient()) proficiencyButton.setSelected(true);
                proficiencyButton.setOnAction(event -> System.out.println("you clicked button"));
                skillRow.getChildren().addAll(skillLabel, proficiencyButton);
                skillsList.getChildren().add(skillRow);
            }
        }
    }
}
