package com.arcanum.compendium.spellbook.service;

import com.arcanum.compendium.environment.Workspace;
import com.arcanum.compendium.spellbook.data.AbilityRepository;
import com.arcanum.compendium.spellbook.data.SpellRepository;
import com.arcanum.compendium.spellbook.domain.Spell;
import com.arcanum.compendium.spellbook.service.dto.SpellDTO;
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

@Service
@AllArgsConstructor
public class SpellService {
    private static final Logger logger = LogManager.getLogger();

    private final SpellRepository abilityRepository;
    private final Workspace workspace;


    public List<SpellDTO> readSpellCasterJson(String path) throws IOException {
        try {
            String spellCasterJson = workspace.readFile(path);
            JSONObject jsonObject = new JSONObject(spellCasterJson);
            JSONObject spells = jsonObject.getJSONObject("spells");

            ObjectMapper objectMapper = new ObjectMapper();
            List<SpellDTO> listToReturn = new ArrayList<>();

            for (Iterator<String> it = spells.keys(); it.hasNext(); ) {
                String key = it.next();
                spells.getJSONArray(key).forEach(spell -> {
                    try {
                        listToReturn.add(objectMapper.readValue(spell.toString(), SpellDTO.class));
                    } catch (IOException e) {
                        logger.error("Failed to read spell: " + e.getMessage());
                    }
                });

            }

            return listToReturn;
        } catch (IOException e) {
            logger.error("Failed to read file " + path + ": \n" + e.getMessage());
            throw new IOException("Failed to read file " + path + ": \n" + e.getMessage());
        }
    }
}
