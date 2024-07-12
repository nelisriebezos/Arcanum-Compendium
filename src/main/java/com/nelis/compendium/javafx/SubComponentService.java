package com.nelis.compendium.javafx;

import com.nelis.compendium.core.service.dtos.MainSkillDTO;
import com.nelis.compendium.core.service.dtos.SubSkillDTO;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.springframework.stereotype.Controller;

@Controller
public class SubComponentService {

    public String getSkillColor(String name) {
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

    public SplitPane createSkillTable(MainSkillDTO dto) {
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
}
