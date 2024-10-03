package com.centime.hibernate.project.task2.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.centime.hibernate.project.task2.entity.GameCharacter;
import com.centime.hibernate.project.task2.repository.GameCharacterRepository;

@Service
public class GameCharacterService {

    @Autowired
    GameCharacterRepository characterRepository;

    public GameCharacter createCharacter(GameCharacter character) {
        return characterRepository.save(character);
    }

    public GameCharacter getCharacterById(Long id) {
        return characterRepository.findById(id).orElse(null);
    }

    public List<GameCharacter> getAllCharacters() {
    	List<GameCharacter> gameCharacters = new ArrayList<>();
    	for (GameCharacter character : characterRepository.findAll()) {
    		gameCharacters.add(character);
    	}
        return gameCharacters;
    }
    
    public List<Map<String, Object>> getNestedCharacters() {
        ///List<GameCharacter> characters = characterRepository.findAll();
    	List<GameCharacter> gameCharacters = new ArrayList<>();
    	for (GameCharacter character : characterRepository.findAll()) {
    		gameCharacters.add(character);
    	}
        Map<Long, Map<String, Object>> map = new LinkedHashMap<>();
        
        // Create a map for parent-child relationship
        for (GameCharacter character : gameCharacters) {
            Map<String, Object> characterMap = new LinkedHashMap<>();
            characterMap.put("Name", character.getName());
            //characterMap.put("Sub Classes", new ArrayList<>());
            map.put(character.getId(), characterMap);
        }
        // Build the nested structure
        List<Map<String, Object>> nestedCharacters = new ArrayList<>();
        buildNestedStructure(gameCharacters,nestedCharacters,map);

        return nestedCharacters;
    }
    
    private List<Map<String, Object>> buildNestedStructure(List<GameCharacter> gameCharacters,
            List<Map<String, Object>> result,Map<Long, Map<String, Object>> map) {

        for (GameCharacter character : gameCharacters) {
            Long parentId = character.getParentid();
            if (parentId == 0) {
                result.add(map.get(character.getId()));
            } else {
                Map<String, Object> parent = map.get(parentId);
                if (parent != null) {
                	 List<Map<String, Object>> children = (List<Map<String, Object>>) parent.getOrDefault("Sub Classes", new ArrayList<>());
                     children.add(map.get(character.getId()));
                     // Add to parent only if there are children
                     parent.put("Sub Classes", children); 
                 }
            }
        }

        return result;
    }
}
