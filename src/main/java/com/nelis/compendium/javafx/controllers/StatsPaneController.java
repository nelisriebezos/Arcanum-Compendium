package com.nelis.compendium.javafx.controllers;

import com.nelis.compendium.Main;
import com.nelis.compendium.core.service.PlayerCharacterService;
import com.nelis.compendium.javafx.dtos.MainSkillDTO;
import com.nelis.compendium.javafx.dtos.SkillRow;
import com.nelis.compendium.javafx.dtos.SubSkillDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

    private void updateSkillBox(List<MainSkillDTO> mainSkillData) {
        TableView<MainSkillDTO> tableView = new TableView<>();
        tableView.setPrefHeight(700.0);
        tableView.setPrefWidth(1000.0);

        // Define columns
        TableColumn<MainSkillDTO, String> skillNameColumn = new TableColumn<>("Skill Name");
        skillNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        skillNameColumn.setPrefWidth(200.0);

        TableColumn<MainSkillDTO, String> skillValueColumn = new TableColumn<>("Value/Modifier");
        skillValueColumn.setCellValueFactory(new PropertyValueFactory<>("value/Modifier"));
        skillValueColumn.setPrefWidth(100.0);


        TableColumn<MainSkillDTO, CheckBox> proficiencyColumn = new TableColumn<>("Proficient");
        proficiencyColumn.setCellValueFactory(param -> {
            MainSkillDTO skillRow = param.getValue();
            CheckBox checkBox = new CheckBox();
            checkBox.setSelected(skillRow.isProficient());
            checkBox.setOnAction(event -> System.out.println("you clicked button"));
            return new javafx.beans.property.SimpleObjectProperty<>(checkBox);
        });
        proficiencyColumn.setPrefWidth(100.0);

        // Add columns to the table
        tableView.getColumns().addAll(skillNameColumn, skillValueColumn, skillModifierColumn, proficiencyColumn);

        // Create an observable list for the table data
        ObservableList<SkillRow> skillRows = FXCollections.observableArrayList();

        // Populate the table data
        for (MainSkillDTO mainSkill : mainSkillData) {
            String plusMinus = mainSkill.baseModifier() > 0 ? " +" : mainSkill.baseModifier() < 0 ? " -" : " 0 ";
            skillRows.add(new SkillRow(mainSkill.baseSkill(), String.valueOf(mainSkill.baseValue()), plusMinus + mainSkill.baseModifier(), false));

            for (SubSkillDTO subSkill : mainSkill.subSkills()) {
                String plusMinusForSkill = subSkill.modifier() > 0 ? " +" : subSkill.modifier() < 0 ? " -" : " 0 ";
                skillRows.add(new SkillRow(subSkill.name(), plusMinusForSkill + subSkill.modifier(), plusMinusForSkill, subSkill.isProficient()));
            }
        }

        // Set the table data
        tableView.setItems(skillRows);

        // Clear any existing children and add the table view
        skillsList.getChildren().clear();
        skillsList.getChildren().add(tableView);

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
//            Label mainSkillModifier = new Label("" + mainSkill.baseModifier());
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
