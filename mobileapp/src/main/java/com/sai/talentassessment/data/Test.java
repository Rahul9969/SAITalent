package com.sai.talentassessment.data;

/**
 * A simple data model to represent a single fitness test.
 */
public class Test {
    private final String name;
    private final String description;
    private final String instructions;

    public Test(String name, String description, String instructions) {
        this.name = name;
        this.description = description;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }
}