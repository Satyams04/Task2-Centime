package com.centime.hibernate.project.task2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game_character")
public class GameCharacter {
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="parentid")
    private Long parentid;

	private String name;
    private String color;
    
    // Constructors
    public GameCharacter() {}

    public GameCharacter(Long id, Long parentid, String name, String color) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.color = color;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public Long getParentid() {
		return parentid;
	}

	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
}
