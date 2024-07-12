package com.nelis.compendium.javafx.controllers;

import com.nelis.compendium.core.service.PlayerCharacterService;
import com.nelis.compendium.javafx.dtos.MainSkillDTO;
import com.nelis.compendium.javafx.dtos.SubSkillDTO;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatsPaneController {
    private final PlayerCharacterService playerCharacterService;

    @FXML
    private VBox skillsList;

    public StatsPaneController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }

    @FXML
    private void initialize() {
        SubSkillDTO skill = new SubSkillDTO("Acrobatics", 2, false);
        SubSkillDTO skill2 = new SubSkillDTO("Animal Handling", -2, true);
        SubSkillDTO skill3 = new SubSkillDTO("Arcana", 0, false);
        SubSkillDTO skill4 = new SubSkillDTO("Athletics", 1, true);
        MainSkillDTO ms1 = new MainSkillDTO("Strength", 10, 0, List.of(skill, skill2));
        MainSkillDTO ms2 = new MainSkillDTO("Dexterity", 10, -2, List.of(skill3, skill4));
        MainSkillDTO ms3 = new MainSkillDTO("Constitution", 10, 0, List.of(skill, skill2));
        MainSkillDTO ms4 = new MainSkillDTO("Intelligence", 10, 5, List.of(skill3, skill4));
        MainSkillDTO ms5 = new MainSkillDTO("Wisdom", 10, 0, List.of(skill, skill2));
        MainSkillDTO ms6 = new MainSkillDTO("Charisma", 10, 0, List.of(skill3, skill4));
        updateSkillBox(List.of(ms1, ms2, ms3, ms4, ms5, ms6));
    }

    private String getSkillColor(String name) {
        return switch (name) {
            case "Strength" -> "#E14545";
            case "Dexterity" -> "#A9C46E";
            case "Constitution" -> "#FF66BC";
            case "Intelligence" -> "#90F1EF";
            case "Wisdom" -> "#D8E3E3";
            case "Charisma" -> "#F3DB6E";
            default -> "#9470B4";
        };
    }

    private SplitPane createSkillTable(MainSkillDTO dto) {
        SplitPane tablePane = new SplitPane();
        tablePane.setOrientation(Orientation.VERTICAL);

        AnchorPane mainSkillPane = new AnchorPane();
        HBox mainSkillRow = new HBox();

        String plusMinusForSkill = " ";
        if (dto.baseModifier() > 0) plusMinusForSkill = " +";

        Label mainSkillName = new Label(dto.name());
        Label mainSkillValue = new Label(plusMinusForSkill + dto.baseValue());
        Label mainSkillModifier = new Label(plusMinusForSkill + dto.baseModifier());

        mainSkillRow.getChildren().addAll(mainSkillName, mainSkillValue, mainSkillModifier);
        mainSkillPane.getChildren().add(mainSkillRow);

        AnchorPane subSkillPane = new AnchorPane();
        VBox subSkillList = new VBox();

        for (SubSkillDTO subSkill : dto.subSkills()) {
            String plusMinusForSubSkill = " ";
            if (dto.baseModifier() > 0) plusMinusForSubSkill = " +";

            HBox skillRow = new HBox();
            Label subSkillName = new Label(subSkill.name());
            Label subSkillValue = new Label(plusMinusForSubSkill + subSkill.modifier());
            CheckBox proficiencyButton = new CheckBox();
            if (subSkill.isProficient()) proficiencyButton.setSelected(true);
            proficiencyButton.setOnAction(event -> System.out.println("you clicked button"));

            skillRow.getChildren().addAll(subSkillName, subSkillValue, proficiencyButton);
            subSkillList.getChildren().add(skillRow);
        }

        subSkillPane.getChildren().add(subSkillList);

        tablePane.getItems().add(mainSkillPane);
        tablePane.getItems().add(subSkillPane);
        return tablePane;
    }

    private void updateSkillBox(List<MainSkillDTO> mainSkillData) {
        for (MainSkillDTO dto : mainSkillData) {
            SplitPane table = createSkillTable(dto);
            skillsList.getChildren().add(table);
        }

//        for (MainSkillDTO mainSkill : mainSkillData) {
//            String plusMinus = " ";
//            if (mainSkill.baseModifier() > 0) plusMinus = " +";
//            String color = getSkillColor(mainSkill.name());
//
//            HBox mainSkillRow = new HBox();
//            mainSkillRow.setStyle("-fx-border-width: 0 0 2px 0; " +
//                    "-fx-border-color: black;" +
//                    "-fx-background-color: " + color + ";" +
//                    "-fx-padding: 5;");
//
//            Label mainSkillName = new Label(mainSkill.name());
//            mainSkillName.setStyle("-fx-font-weight: bold; -fx-padding: 0 10 0 0;");
//
//            Label mainSkillValue = new Label("" + mainSkill.baseValue());
//            mainSkillValue.setStyle("-fx-font-weight: bold; -fx-padding: 0 10 0 0;");
//
//            Label mainSkillModifier = new Label(plusMinus + mainSkill.baseModifier());
//            mainSkillModifier.setStyle("-fx-font-weight: bold; -fx-padding: 0 10 0 0;");
//
//            mainSkillRow.getChildren().addAll(mainSkillName, mainSkillValue, mainSkillModifier);
//            skillsList.getChildren().add(mainSkillRow);
//
//            // Add skills to the skills list
//            for (SubSkillDTO subSkill : mainSkill.subSkills()) {
//                String plusMinusForSkill = " ";
//                if (mainSkill.baseModifier() > 0) plusMinusForSkill = " +";
//
//                HBox skillRow = new HBox();
//                Label subSkillName = new Label(subSkill.name());
//
//                Label subSkillValue = new Label(plusMinusForSkill + subSkill.modifier());
//
//                CheckBox proficiencyButton = new CheckBox();
//                if (subSkill.isProficient()) proficiencyButton.setSelected(true);
//                proficiencyButton.setOnAction(event -> System.out.println("you clicked button"));
//
//                skillRow.getChildren().addAll(subSkillName, subSkillValue, proficiencyButton);
//                skillsList.getChildren().add(skillRow);
//            }
//        }
    }
}
