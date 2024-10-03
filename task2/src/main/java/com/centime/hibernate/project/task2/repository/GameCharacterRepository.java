package com.centime.hibernate.project.task2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.centime.hibernate.project.task2.entity.GameCharacter;

@Repository
public interface GameCharacterRepository extends CrudRepository<GameCharacter, Long>{

}
