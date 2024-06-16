package com.arcanum.compendium.spellbook.service;

import com.arcanum.compendium.spellbook.data.AbilityRepository;
import com.arcanum.compendium.spellbook.domain.Ability;
import com.arcanum.compendium.spellbook.service.exception.AbilityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AbilityService {
    private final AbilityRepository abilityRepository;

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
