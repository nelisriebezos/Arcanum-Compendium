package com.arcanum.compendium;

import com.arcanum.compendium.spellbook.service.AbilityService;
import com.arcanum.compendium.spellbook.service.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {
    private final AbilityService abilityService;
    private final SpellService spellService;

    @Override
    public void run(String... args) throws Exception {
//        spellService.readSpellCasterJson("src/main/resources/dummydata/firstTestJson.json");
    }
}


