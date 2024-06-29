package com.arcanum.compendium;

import com.arcanum.compendium.core.player.service.SpellService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Runner implements CommandLineRunner {
    private final SpellService spellService;

    @Override
    public void run(String... args) throws Exception {
    }
}


