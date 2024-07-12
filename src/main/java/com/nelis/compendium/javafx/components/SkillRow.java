package com.nelis.compendium.javafx.components;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

public class SkillRow {
    private final StringProperty name;
    private final StringProperty value;
    private final StringProperty modifier;
    private final boolean proficient;

    public SkillRow(String name, String value, String modifier, boolean proficient) {
        this.name = new SimpleStringProperty(name);
        this.value = new SimpleStringProperty(value);
        this.modifier = new SimpleStringProperty(modifier);
        this.proficient = proficient;
    }

    public SkillRow(String name, String value, String modifier) {
        this(name, value, modifier, false);
    }

    public SkillRow(String name, String modifier, boolean proficient) {
        this(name, "", modifier, proficient);
    }

    public String getName() {
        return name.get();
    }

    public String getValue() {
        return value.get();
    }

    public String getModifier() {
        return modifier.get();
    }

    public boolean isProficient() {
        return proficient;
    }
}
