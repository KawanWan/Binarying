package com.binarying.binproject.entities;


import org.springframework.data.relational.core.mapping.Column;

import com.binarying.binproject.entities.enumerations.Difficulty;

import jakarta.validation.constraints.Max;

public class Student extends User {
    private Long exp;
    @Max(5)
    private Integer life;
    @Column("isadventure")
    private Boolean isAdventure;
    private Difficulty difficulty;

    private Integer[] progress;
    
    
    public Student(Integer id, String username, String password, Boolean isAdventure, Difficulty difficulty) {
        super(id, username, password);
        this.exp = 0L;
        this.life = 5;
        this.isAdventure = isAdventure;
        this.difficulty = difficulty;
        this.progress = new Integer[0];
    }

    public Long getExp() {
        return exp;
    }

    public void increaseExp(Long exp) {
        this.exp += exp;
    }

    public Integer getLife() {
        return life;
    }

    public void increaseLife() {
        if (life < 5) {
        this.life++;
        }
    }
    
    public void decreaseLife() {
        if (life > 0) {
        this.life--;
        }
    }
    
    public Boolean getIsAdventure() {
        return isAdventure;
    }

    public void setIsAdventure(Boolean isAdventure) {
        this.isAdventure = isAdventure;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Integer[] getProgress() {
        return progress;
    }

    public void addProgress(Integer value) {
        Integer[] newProgress = new Integer[progress.length + 1];
        for (int i = 0; i < progress.length; i++) {
            newProgress[i] = progress[i];
        }
        newProgress[progress.length] = value;
        progress = newProgress;
    }
}
