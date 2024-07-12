package com.nelis.compendium.javafx;

import com.nelis.compendium.Main;
import com.nelis.compendium.core.domain.PlayerCharacter;
import com.nelis.compendium.core.domain.skills.MainSkill;
import com.nelis.compendium.core.domain.skills.Skill;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

import static com.nelis.compendium.core.domain.skills.SkillName.*;
import static com.nelis.compendium.core.domain.skills.SkillType.*;

@Component
@Getter
@Setter
public class FxmlStateService {
    private PlayerCharacter playerCharacter;

    public void loadInCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
