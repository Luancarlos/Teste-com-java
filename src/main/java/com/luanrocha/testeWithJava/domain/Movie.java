package com.luanrocha.testeWithJava.domain;
public class Movie {
    private Long code;
    private String name;
    private String description;
    private String category;

    public Movie() {

    }

    public Movie(Long code, String name, String description, String category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
