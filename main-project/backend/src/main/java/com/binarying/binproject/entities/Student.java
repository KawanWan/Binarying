package com.binarying.binproject.entities;

public class Student extends User {
    private Long exp;
    private Integer life;

    
    public Student(Integer id, String username, String password, Long exp, Integer life) {
        super(id, username, password);
        this.exp = exp;
        this.life = life;
    }

    public Long getExp() {
        return exp;
    }
    public void setExp(Long exp) {
        this.exp = exp;
    }
    public Integer getLife() {
        return life;
    }
    public void setLife(Integer life) {
        this.life = life;
    }

}
