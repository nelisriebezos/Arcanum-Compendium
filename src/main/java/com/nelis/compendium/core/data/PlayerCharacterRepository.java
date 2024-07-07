package com.nelis.compendium.core.data;

import com.nelis.compendium.core.domain.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.UUID;

@Repository
public interface PlayerCharacterRepository extends JpaRepository<PlayerCharacter, UUID> {
}
