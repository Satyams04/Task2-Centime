package com.centime.hibernate.project.task2.populateData;

import com.centime.hibernate.project.task2.entity.GameCharacter;
import com.centime.hibernate.project.task2.repository.GameCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private GameCharacterRepository gameCharacterRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insert initial data into the database
        gameCharacterRepository.save(new GameCharacter(1L, 0L, "Warrior", "red"));
        gameCharacterRepository.save(new GameCharacter(2L, 0L, "Wizard", "green"));
        gameCharacterRepository.save(new GameCharacter(3L, 0L, "Priest", "white"));
        gameCharacterRepository.save(new GameCharacter(4L, 0L, "Rogue", "yellow"));
        gameCharacterRepository.save(new GameCharacter(5L, 1L, "Fighter", "blue"));
        gameCharacterRepository.save(new GameCharacter(6L, 1L, "Paladin", "lightblue"));
        gameCharacterRepository.save(new GameCharacter(7L, 1L, "Ranger", "lightgreen"));
        gameCharacterRepository.save(new GameCharacter(8L, 2L, "Mage", "grey"));
        gameCharacterRepository.save(new GameCharacter(9L, 2L, "Specialist wizard", "lightgrey"));
        gameCharacterRepository.save(new GameCharacter(10L, 3L, "Cleric", "red"));
        gameCharacterRepository.save(new GameCharacter(11L, 3L, "Druid", "green"));
        gameCharacterRepository.save(new GameCharacter(12L, 3L, "Priest of specific mythos", "white"));
        gameCharacterRepository.save(new GameCharacter(13L, 4L, "Thief", "yellow"));
        gameCharacterRepository.save(new GameCharacter(14L, 4L, "Bard", "blue"));
        gameCharacterRepository.save(new GameCharacter(15L, 13L, "Assassin", "lightblue"));
    }
}