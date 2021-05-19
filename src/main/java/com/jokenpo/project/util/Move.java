package com.jokenpo.project.util;

public enum Move {
    PEDRA(0),

    TESOURA(1),

    PAPEL(2);

    private int id;
    private String description;

    Move(int id) {
        this.id = id;
        if (id == 0) {
            description = "Pedra";
        }
        if (id == 1) {
            description = "Tesoura";
        }
        if (id == 2) {
            description = "Papel";
        }
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
