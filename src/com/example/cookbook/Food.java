package com.example.cookbook;

import java.io.Serializable;

/**
 * Created by bagas on 8/26/14.
 */
public class Food implements Serializable {

    private Integer title;
    private Integer from;
    private Integer resId;
    private Integer ingredients;
    private Integer instructions;

    public Food(Integer title, Integer from, Integer resId, Integer ingredients, Integer instructions) {
        this.title = title;
        this.from = from;
        this.resId = resId;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public Integer getIngredients() {
        return ingredients;
    }

    public void setIngredients(Integer ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getInstructions() {
        return instructions;
    }

    public void setInstructions(Integer instructions) {
        this.instructions = instructions;
    }
}
