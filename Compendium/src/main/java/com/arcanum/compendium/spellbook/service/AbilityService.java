package com.arcanum.compendium.spellbook.service;

import com.arcanum.compendium.environment.Workspace;
import com.arcanum.compendium.spellbook.data.AbilityRepository;
import com.arcanum.compendium.spellbook.domain.Ability;
import com.arcanum.compendium.spellbook.service.dto.SpellDTO;
import com.arcanum.compendium.spellbook.service.exception.AbilityNotFound;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AbilityService {
    private static final Logger logger = LogManager.getLogger();

    private final AbilityRepository abilityRepository;
    private final Workspace workspace;

    public Ability createAbility(Ability ability) {
        return abilityRepository.save(ability);
    }

    public Ability getAbility(UUID uuid) {
        return abilityRepository.findById(uuid).orElseThrow(() -> new AbilityNotFound(uuid));
    }

    public List<Ability> getAllAbilities() {
        return abilityRepository.findAll();
    }

    public Ability updateAbility(Ability ability) {
        return abilityRepository.save(ability);
    }

    public void deleteAbility(UUID uuid) {
        abilityRepository.deleteById(uuid);
    }

}
