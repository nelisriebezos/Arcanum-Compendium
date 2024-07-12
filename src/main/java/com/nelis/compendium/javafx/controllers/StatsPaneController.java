package com.nelis.compendium.javafx.controllers;

import com.nelis.compendium.Main;
import com.nelis.compendium.core.service.PlayerCharacterService;
import com.nelis.compendium.javafx.dtos.MainSkillDTO;
import com.nelis.compendium.javafx.dtos.SubSkillDTO;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StatsPaneController {
    private final PlayerCharacterService playerCharacterService;
    private final Main main;

    @FXML
    private VBox skillsList;

    public StatsPaneController(PlayerCharacterService playerCharacterService, Main main) {
        this.playerCharacterService = playerCharacterService;
        this.main = main;
    }

    @FXML
    private void initialize() {
        SubSkillDTO skill = new SubSkillDTO("Acrobatics", 2, false);
        SubSkillDTO skill2 = new SubSkillDTO("Animal Handling", -2, true);
        SubSkillDTO skill3 = new SubSkillDTO("Arcana", +5, false);
        SubSkillDTO skill4 = new SubSkillDTO("Athletics", 1, false);
        MainSkillDTO ms1 = new MainSkillDTO("Strength", 10, 0, List.of(skill, skill2));
        MainSkillDTO ms2 = new MainSkillDTO("Dexterity", 10, -2, List.of(skill3, skill4));
        updateSkillBox(List.of(ms1, ms2));
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
        mainSkillRow.setSpacing(10);
        mainSkillRow.setPadding(new Insets(5));
        mainSkillRow.setStyle("-fx-background-color: " + getSkillColor(dto.name()) + ";");

        String plusMinusForSkill = "  ";
        if (dto.baseModifier() > 0) plusMinusForSkill = "+";

        Label mainSkillName = new Label(dto.name());
        mainSkillName.setPrefWidth(100);
        mainSkillName.setStyle("-fx-font-weight: bold;");

        Label mainSkillValue = new Label("" + dto.baseValue());
        mainSkillValue.setPrefWidth(35);
        mainSkillValue.setStyle("-fx-font-weight: bold;");

        Label mainSkillModifier = new Label(plusMinusForSkill + dto.baseModifier());
        mainSkillModifier.setPrefWidth(35);
        mainSkillModifier.setStyle("-fx-font-weight: bold;");

        mainSkillRow.getChildren().addAll(mainSkillName, mainSkillValue, mainSkillModifier);
        mainSkillPane.getChildren().add(mainSkillRow);

        AnchorPane subSkillPane = new AnchorPane();
        VBox subSkillList = new VBox();
        subSkillList.setSpacing(10);
        subSkillList.setPadding(new Insets(5));

        for (SubSkillDTO subSkill : dto.subSkills()) {

            String plusMinusForSubSkill = " ";
            if (subSkill.modifier() > 0) plusMinusForSubSkill = "+";


            HBox skillRow = new HBox();
            skillRow.setSpacing(10);
            skillRow.setPadding(new Insets(5));

            Label subSkillName = new Label(subSkill.name());
            subSkillName.setPrefWidth(100);

            Label subSkillValue = new Label(plusMinusForSubSkill + subSkill.modifier());
            subSkillValue.setPrefWidth(35);

            CheckBox proficiencyButton = new CheckBox();
            subSkillValue.setPrefWidth(35);

            if (subSkill.isProficient()) proficiencyButton.setSelected(true);
            proficiencyButton.setOnAction(event -> System.out.println("you clicked button"));

            skillRow.getChildren().addAll(subSkillName, subSkillValue, proficiencyButton);
            subSkillList.getChildren().add(skillRow);
        }

        subSkillPane.getChildren().add(subSkillList);

        tablePane.getItems().add(mainSkillPane);
        tablePane.getItems().add(subSkillPane);

        SplitPane.setResizableWithParent(mainSkillPane, false);
        SplitPane.setResizableWithParent(subSkillPane, false);
        return tablePane;
    }

    private void updateSkillBox(List<MainSkillDTO> mainSkillData) {
        for (MainSkillDTO dto : mainSkillData) {
            SplitPane table = createSkillTable(dto);
            skillsList.getChildren().add(table);
        }
//
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
//    }
    }
}
