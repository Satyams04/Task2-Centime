package com.centime.hibernate.project.task2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.centime.hibernate.project.task2.entity.GameCharacter;
import com.centime.hibernate.project.task2.logging.LogMethodParam;
import com.centime.hibernate.project.task2.service.GameCharacterService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/gameCharacters")
public class GameCharacterController {

    @Autowired
    GameCharacterService gameCharacterService;
   
    @PostMapping("/create")
    @LogMethodParam 
    public ResponseEntity<GameCharacter> creategameCharacter(@RequestBody GameCharacter gameCharacter) {
        return new ResponseEntity<>(gameCharacterService.createCharacter(gameCharacter), HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<GameCharacter> getGameCharacterById(@PathVariable Long id) {
        GameCharacter gameCharacter = gameCharacterService.getCharacterById(id);
        return gameCharacter != null ? new ResponseEntity<>(gameCharacter, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GameCharacter>> getAllGameCharacters() {
        List<GameCharacter> gameCharacters = gameCharacterService.getAllCharacters();
        return new ResponseEntity<>(gameCharacters, HttpStatus.OK);
    }
    
    @GetMapping("/getNestedCharacters")
    @LogMethodParam 
    public ResponseEntity<List<Map<String, Object>>> getNestedGameCharacters() {
        List<Map<String, Object>> nestedCharacters = gameCharacterService.getNestedCharacters();
        return  new ResponseEntity<>(nestedCharacters, HttpStatus.OK);
    }

}
